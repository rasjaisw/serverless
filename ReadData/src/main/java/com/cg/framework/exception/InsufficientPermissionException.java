package com.cg.framework.exception;

import java.util.List;

import com.cg.framework.validation.ErrorMessage;

/**This class is used when there user does not have a permission to perform the specific action.
 * 
 * @author anangupt
 *
 */

public class InsufficientPermissionException extends RuntimeException {

	private static final long serialVersionUID = -8418416790186826900L;
	
	
	private final  List<ErrorMessage> errorMessage;
	
	/**This constructor is used when only errorMessage are used to report the exception.
	 * 
	 * @param exp
	 */
	
	public InsufficientPermissionException(List<ErrorMessage> errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public InsufficientPermissionException(String message, Throwable cause) {
		super(message , cause);
		errorMessage = null;
	}
	
   /** This constructor is used when only cause is used to report the exception.
    * 
    * @param cause
    */
	public InsufficientPermissionException(Throwable cause) {
		super(cause);
		errorMessage = null;
	}

	public List<ErrorMessage> getErrorMessage() {
		return errorMessage;
	}
	
}
