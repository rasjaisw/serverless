package com.cg.user.response;

import java.io.Serializable;
import java.util.List;

import com.cg.framework.base.BaseResponse;
import com.cg.framework.base.auth.UserProfileDTO;

/**<Strong> This Class is used to hold all the user create and update request.</Strong> 
 * 
 * @author anangupt
 *
 */
public class UserResponse extends BaseResponse implements Serializable{

	private static final long serialVersionUID = 915118192143971046L;

	private String message;


	/**True when there is users in the list.
	 *  
	 */
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
