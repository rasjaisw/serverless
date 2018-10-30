package com.cg.framework.exception;

import java.util.List;

import com.cg.framework.validation.ErrorMessage;

/**This class is used when there is no valid session for the user.
 * 
 * @author anangupt
 *
 */

public class InvalidSessionException extends Exception {

	private static final long serialVersionUID = 4745573928400460465L;

	private final  List<ErrorMessage> errorMessage;
	
	/**This constructor is used when only errorMessage are used to report the exception.
	 * 
	 * @param exp
	 */
	
	public InvalidSessionException(List<ErrorMessage> errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public InvalidSessionException(String message, Throwable cause) {
		super(message , cause);
		errorMessage = null;
	}
	
   /** This constructor is used when only cause is used to report the exception.
    * 
    * @param cause
    */
	public InvalidSessionException(Throwable cause) {
		super(cause);
		errorMessage = null;
	}

	public List<ErrorMessage> getErrorMessage() {
		return errorMessage;
	}
	
}
