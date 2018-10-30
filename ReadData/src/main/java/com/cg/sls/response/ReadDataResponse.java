package com.cg.sls.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cg.framework.base.BaseResponse;
import com.cg.framework.base.auth.UserProfileDTO;

/**<Strong> This Class is used to hold all the user create and update request.</Strong> 
 * 
 * @author anangupt
 *
 */
public class ReadDataResponse extends BaseResponse implements Serializable{

	private static final long serialVersionUID = 915118192143971046L;

	private String message;
	private  List<Map<Object, Object>> output;


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

	public List<Map<Object, Object>> getOutput() {
		return this.output;
	}
	
	public void setOutput(List<Map<Object, Object>> response)
	{
		this.output = response;
	}

}
