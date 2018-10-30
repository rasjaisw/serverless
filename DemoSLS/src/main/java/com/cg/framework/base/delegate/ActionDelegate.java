package com.cg.framework.base.delegate;

import com.cg.framework.base.BaseRequest;
import com.cg.framework.base.auth.AuthDTO;
import com.cg.framework.base.auth.AuthObject;
import com.cg.framework.constant.RoleConstant;
import com.cg.framework.exception.InvalidSessionException;
import com.cg.framework.validation.ActionErrorMessage;

/**
 * This abstraction is used to have all the methods which are used to process the incoming request or action.
 * T1- this type represent the input request object.
 * T2 - this type represent the input response object.
 * 
 */
public interface ActionDelegate<T1 extends BaseRequest,T2> {
	
	/**This method is used as as entry point point of the request processing and should be called to delegate the 
	 * request processing.
	 * 
	 * @param t1:input type
	 * @return T2:response type
	 */
	public T2 delegate(T1 t1 ) throws InvalidSessionException ;
	
	/**This method is used to authorize  the incoming request against the auth token also used to validate against the role.
	 * @param authObject
	 * @return AuthDTO
	 */
	
	public AuthDTO doAuthorization(AuthObject authObject) throws InvalidSessionException;
	
	/** This method will have all the logic to process the input request.
	 * The validation call, service call and response object processing is done using this method.
	 * @param t1:input type
	 * @param authObject
	 * @return T2:response type
	 */
	public T2 doProcess(T1 t1, AuthDTO authObject);
	
	/**This method is used process validation against the input provided from the UI.
	 * 
	 * @param t1:input type
	 * @param authObject
	 * @return ActionErrorMessage
	 */
	public ActionErrorMessage doValidation(T1 t1,AuthDTO authObject);
	
	
    /**This method check for the whether user has a permission to access the api.
     * 
     * @param authObject
     * @return ActionErrorMessage
     */
    public boolean checkPermisssion(AuthDTO authObject, RoleConstant role);
    
    
    /**This method do the pre validation and it could be role check or calling the validation method.
     * 
     * @param authObject
     * @return ActionErrorMessage
     */
    public boolean preValidation(T1 t1, AuthDTO authObject);
    
	
    /**This method check for the whether user has a permission to access the api.
     * 
     * @param authObject
     * @param auctionid
     * @return ActionErrorMessage
     */
    public boolean checkPermisssion(AuthDTO authObject,String auctionId, RoleConstant role);

}
