package com.cg.user.request;

import java.io.Serializable;

/*This class is to hold the login user id and password for authentication external user.
 * 
 * @author anangupt
 *
 */

public class UserAuthenticationRequest implements Serializable {
	
	
	private static final long serialVersionUID = -6880973592744533529L;
	
	/*
	 * login id is the user id for AFC protal.
	 */
	private String userId;
	
	/*
	 * login password is the user id for AFC protal.
	 */
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
