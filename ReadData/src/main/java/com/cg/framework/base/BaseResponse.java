package com.cg.framework.base;

import java.io.Serializable;
import java.util.List;

import com.cg.framework.validation.ErrorMessage;

/**This class is composed of list of ErrorMessage and every labda response object will extends
 * this class.
 * 
 * @author anangupt
 *
 */
public class BaseResponse implements Serializable{

	private static final long serialVersionUID = -6280393324548572368L;
	
	/**This list contain the list of error message object which will be shown to UI if present.
	 * 
	 */
	private List<ErrorMessage> errorMessages;

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}

	

	
	

}
