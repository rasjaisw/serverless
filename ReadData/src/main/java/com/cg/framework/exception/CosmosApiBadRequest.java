package com.cg.framework.exception;

import java.io.Serializable;
import java.util.List;

/**This class is used when there is an exception in COSMOS API  like wrong db, query issue
 *  or any validations.
 * 
 * @author anangupt
 *
 */
public class CosmosApiBadRequest implements Serializable {

	private static final long serialVersionUID = 722921260222349L;
	
	/**List of error message contains by the exception.
	 * 
	 */
	private List<RestErrorMessage> errorMessages;

	public List<RestErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<RestErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	 
}
