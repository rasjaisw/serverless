package com.cg.framework.exception;

/**This class is used when there is a issue in loading resource file..
 * 
 * @author anangupt
 *
 */

public class PropertyFileLoadingException extends RuntimeException {


	private static final long serialVersionUID = 6565431669274878611L;

	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public PropertyFileLoadingException(String message, Throwable cause) {
		super(message , cause);
	}

	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public PropertyFileLoadingException(String message) {
		super(message);
	}

	/** This constructor is used when only cause is used to report the exception.
	 * 
	 * @param cause
	 */
	public PropertyFileLoadingException(Throwable cause) {
		super(cause);
	}


}
