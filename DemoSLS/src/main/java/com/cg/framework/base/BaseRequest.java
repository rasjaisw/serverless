package com.cg.framework.base;

import java.io.Serializable;

import com.cg.framework.base.auth.AuthObject;

/**This class composed of AuthObject class and will be implemented by all Lambda request object.
 * 
 * @author anangupt
 *
 */

public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 5651969487696525972L;
	
	/**This object contains the auth parameter which are passed as input.
	 * 
	 */
	private AuthObject authObject;

	public AuthObject getAuthObject() {
		return authObject;
	}

	public void setAuthObject(AuthObject authObject) {
		this.authObject = authObject;
	}
	
	
}
