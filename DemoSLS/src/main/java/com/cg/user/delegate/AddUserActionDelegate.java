package com.cg.user.delegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import  com.cg.framework.base.auth.AuthDTO;
import  com.cg.framework.base.delegate.AbstractActionDelegate;
import  com.cg.framework.constant.RoleConstant;
import  com.cg.framework.util.TerritoryLocal;
import com.cg.framework.validation.ActionErrorMessage;
import  com.cg.framework.validation.ImpersonateUserValidator;
import  com.cg.framework.validation.MessageData;
import com.cg.user.constant.MessageConstant;
//import com.cg.user.okta.user.UserCreationResponse;
import com.cg.user.request.UserRequest;
import com.cg.user.response.UserResponse;
import com.cg.user.validator.AddUserValidator;

/**
 * This class has the concrete implementation of doProcess method
 * 
 * @author anangupt
 *
 */
@Component
public class AddUserActionDelegate extends AbstractActionDelegate<UserRequest, UserResponse> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddUserActionDelegate.class);


	@Autowired
	ImpersonateUserValidator impersonateUserValidator;
	
	@Autowired
	AddUserValidator addUserValidator;

	/**
	 * This method does the initial validation and passes the request object to the
	 * add OKTA service.
	 */
	public UserResponse doProcess(UserRequest userRequest, AuthDTO authObject) {

		LOGGER.info("enter::AddUserActionDelegate::doProcess {}", userRequest);
		
		UserResponse userResponse = new UserResponse();
		//UserCreationResponse userCreationResponse = null;
/*		ActionErrorMessage actionErrorMessage = preProcessing(userRequest, authObject);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			userResponse.setErrorMessages(actionErrorMessage.getErrorMessage());
			LOGGER.info("exit::AddUserActionDelegate::doProcess::error in preProcessing");
			return userResponse;
		}
*/		userResponse.setMessage("user created succesfully");
		return userResponse;
	}

	/**
	 * PreProcessing the input.
	 * 
	 * @param userRequest
	 * @param authObject
	 * @return
	 */
	private ActionErrorMessage preProcessing(UserRequest userRequest, AuthDTO authObject) {
		
		
		ActionErrorMessage actionErrorMessage = null;
//		validate input parameters.
		actionErrorMessage = doValidation(userRequest,authObject);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			LOGGER.info("exit::AddUserActionDelegate::preProcessing::doValidation");
			return actionErrorMessage;
		}
//	    Check the permission to create with list of auction.
		actionErrorMessage = checkPermisssion(authObject, userRequest);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			LOGGER.info("exit::AddUserActionDelegate::preProcessing::checkPermisssion");
			return actionErrorMessage;
		}
		
		return null;
	}

	/**Check the user has the permission to create a user with selected list of auction.
	 * 
	 * @param authObject
	 * @param userRequest
	 * @return
	 */
	public ActionErrorMessage checkPermisssion(AuthDTO authObject,UserRequest userRequest) {

		ActionErrorMessage actionErrorMessage = null;
		boolean havePermission = false;
		// check whether add/edit permission is present
		
		if (authObject.getProfile().isInternal()) {
			if (checkPermisssion(authObject, RoleConstant.ADD_EDIT_USERS)) {
				havePermission = true;
			}
		}else {
			for (String auction : userRequest.getAuctions()) {
				if (!checkPermisssion(authObject,auction, RoleConstant.ADD_EDIT_USERS)) {
					havePermission = false;
					break;
				}else {
					havePermission = true;
				}
			}
		}
		if ( ! havePermission) {
			actionErrorMessage =  genericMessageHandler.doProcess(MessageConstant.UA0006.val(), MessageData.ERROR, TerritoryLocal.getLocal(TerritoryLocal.US));
			LOGGER.error("AddUserActionDelegate::checkPermisssion::User does not have add/edit permission");
		}
		return actionErrorMessage;

	}

	/**
	 * This method check for the whether user has a permission to access the api.
	 * 
	 * @param authObject
	 * @return boolean
	 */
	@Override
	public boolean checkPermisssion(AuthDTO authObject, RoleConstant role) {
		boolean isPermission = true;
		if (authObject.getPermissions() == null || !(authObject.getPermissions().contains(role.getVal()))) {
			isPermission = false;
		}
		return isPermission;
	}

	/**validate the input request.
	 * 
	 */
	@Override
	public ActionErrorMessage doValidation(UserRequest userRequest, AuthDTO authObject) {
		LOGGER.info("AddUserActionDelegate::doValidation");
		return addUserValidator.doValidate(userRequest, authObject);
	}

}
