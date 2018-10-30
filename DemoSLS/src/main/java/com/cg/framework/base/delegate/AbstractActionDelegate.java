package com.cg.framework.base.delegate;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cg.framework.base.BaseRequest;
import com.cg.framework.base.auth.AuthDTO;
import com.cg.framework.base.auth.AuthObject;
import com.cg.framework.cache.CachingService;
import com.cg.framework.constant.CommonConstant;
import com.cg.framework.constant.EnvConstant;
import com.cg.framework.constant.RoleConstant;
import com.cg.framework.exception.CosmosApiBadRequest;
import com.cg.framework.exception.ExceptionConstant;
import com.cg.framework.exception.InvalidSessionException;
import com.cg.framework.messagehandler.GenericMessageHandler;
import com.cg.framework.util.DateUtil;
import com.cg.framework.util.ExceptionMessageUtil;
import com.cg.framework.util.JsonUtil;
import com.cg.framework.util.TerritoryLocal;
import com.cg.framework.validation.ActionErrorMessage;
import com.cg.framework.validation.ErrorMessage;
import com.cg.framework.validation.MessageConstant;
import com.cg.framework.validation.MessageData;

/** This class is used to have the common implementation  of the interface ActionDelegate methods.
 * 
 * @author anangupt
 *
 * @param <T1>: input type
 * @param <T2>:response type
 */
@Component
public  abstract class AbstractActionDelegate<T1 extends BaseRequest, T2> implements ActionDelegate<T1, T2> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractActionDelegate.class);
	
	@Autowired
	@Qualifier("authCacheService")
	protected CachingService<AuthDTO> cachingService;
	
	@Autowired
	protected GenericMessageHandler genericMessageHandler;
	
	/**This method is used to call other method and will be called first to start processing of input.
	 * @throws InvalidSessionException 
	 * 
	 */
	@Override
	public T2 delegate(T1 t1  ) throws InvalidSessionException {
/*		AuthDTO authDTO  = doAuthorization(t1.getAuthObject());
		boolean prevalidation = preValidation(t1, authDTO);
		if(prevalidation) {
			return doProcess(t1,authDTO);
		}
		return null;*/
		
		
		return doProcess(t1,new AuthDTO());
	}

	/**This method is used to have the implementation details of user authorization.
	 * @throws InvalidSessionException 
	 * 
	 */
	@Override
	public AuthDTO doAuthorization(AuthObject authObject) throws InvalidSessionException {
		AuthDTO authDTO = null;
		if (authObject != null && authObject.getAuthorizationId() != null ) {
			authDTO  = cachingService.get(authObject.getAuthorizationId(), AuthDTO.class);
			
		}
		validateSessionToken(authDTO);
		/**
		 * if session is valid update the session timeout to current time.
		 */
		cachingService.put(authObject.getAuthorizationId(), authDTO);
		return authDTO;
	}

	/** This method is used to validate the session for predefine time. if it will not fall in predefine time
	 *  then it throws the  Invalid session exception.
	 * 
	 */
	private void validateSessionToken(AuthDTO authdto) throws InvalidSessionException {

		if( authdto==null ) {
			LOGGER.error("AUTH OBJECT IS NULL");
			throw invalidSessionBuilder(MessageConstant.FW0002, MessageData.ERROR);
		}
		String sessionTimeout = EnvConstant.SESSION_TIME_OUT.getVal();
		if(sessionTimeout ==null || sessionTimeout.trim().isEmpty()) {
			sessionTimeout = "5";
		}
		long sessionDuration = 1000*60* Long.parseLong(sessionTimeout);
		long currTime = DateUtil.getUTCTimeinMillis();
		long prevAccessTime = Long.parseLong(authdto.getLoginTime());

		if((currTime-prevAccessTime) > sessionDuration) {
			LOGGER.info("CURRTIME-PREVACCESSTIME VALUE IS {}" ,(currTime-prevAccessTime));
			invalidSessionBuilder(MessageConstant.FW0002, MessageData.ERROR);
		}
	
	}
	
	/**This method used to form the invalid session exception which will be thrown when either there is
	 * no valid token id has been passed or user will return after pre define session time.
	 * 
	 * @param code
	 * @param type
	 * @return
	 * @throws InvalidSessionException 
	 */
	private InvalidSessionException invalidSessionBuilder(String code, String type) throws InvalidSessionException {
		ActionErrorMessage actionErrorMessage = genericMessageHandler.doProcess(CommonConstant.COMMON_MSG.getVal(),code, type, TerritoryLocal.getLocal(TerritoryLocal.US));
		throw new InvalidSessionException(actionErrorMessage.getErrorMessage());
	}
	
	/**This method is used process validation against the input provided from the UI.
	 * 
	 * @param t1:input type
	 * @param authObject
	 * @return ActionErrorMessage
	 */
	@Override
	public ActionErrorMessage doValidation(T1 t1,AuthDTO authObject) {
		return null;
	}
	
    /**This method check for the whether user has a permission to access the api.
     * 
     * @param authObject
     * @return boolean
     */
	@Override
    public boolean checkPermisssion(AuthDTO authObject, RoleConstant role) {
    	boolean isPermission = false;
    	if(authObject.getPermissions() == null || !(authObject.getPermissions().contains(role.getVal()))) {
    		isPermission = true;
    	}
    	return isPermission;
    }
	
	
    /**This method check for the whether user has a permission to access the api.
     * 
     * @param authObject
     * @return boolean
     */
	@Override
    public boolean checkPermisssion(AuthDTO authObject,String auctionId, RoleConstant role) {
    	boolean isPermission = false;
    	
    	Set<String> permissions = authObject.getAuctionPermissionsMap().get(auctionId);
    	
    	if(permissions == null || permissions.isEmpty()) {
    		return false;
    	}
    	
    	if( permissions.contains(role.getVal())) {
    		isPermission = true;
    	}
    	return isPermission;
    }
	
	
	/**This class process REST API  validation exception and returns the List<ErrorMessage> by 
	 * setting the Error code and Error Description.
	 * 
	 * @return List<ErrorMessage>
	 */
	protected List<ErrorMessage>  processRestValiation(String responseBodyAsString) {
		
		LOGGER.info("REST CLIENT ERROR RESPONSE BODY {}",responseBodyAsString);
		CosmosApiBadRequest restErrorMessage = JsonUtil.convertToObject(responseBodyAsString, CosmosApiBadRequest.class);
		return  ExceptionMessageUtil.populateErrorMessage(restErrorMessage, MessageData.ERROR );
	}

	/**This class process REST API  failure and populate the constant code and message.
	 * 
	 * @return List<ErrorMessage>
	 */
	protected List<ErrorMessage>  processRestConnectionFailure( ) {
		return ExceptionMessageUtil.populateErrorMessage(ExceptionConstant.REST_CLIENT_CONNECTION_CODE.getVal(),
				ExceptionConstant.REST_CLIENT_CONNECTION_SUMMARY.getVal(), MessageData.ERROR);
	}
	
	
    /**This method is used for pre validation of input request.
     * 
     * @param authObject
     * @return boolean
     */
	@Override
    public boolean preValidation(T1 t1, AuthDTO authObject) {
		
    	return true;
    }
	
	
}
