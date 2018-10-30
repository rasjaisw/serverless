package com.cg.framework.base.auth;

import java.io.Serializable;

/**This class used to carry all the auth parameters passed as input from UI.
 * 
 * @author anangupt
 *
 */
public class AuthObject implements Serializable {

	private static final long serialVersionUID = 866628829125982190L;
	
	
	/**Roles of login customer.
	 * 
	 */
	private String userId;
	
	/**User id of authorizationId.
	 * 
	 */
	private String authorizationId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}

	
	
}
