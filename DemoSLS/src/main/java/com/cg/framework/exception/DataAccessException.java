package com.cg.framework.exception;

/**This class is used when there is exception while communicating to DB.
 * 
 * @author anangupt
 *
 */

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1202546211986070814L;
	
	/**Error code which will assign to exception.
	 * 
	 */
	String errorCode;
	
	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public DataAccessException(String message,String errorCode, Throwable cause) {
		super(message , cause);
		this.errorCode = errorCode;
	}
	
	/** This constructor is used when message is used to report the exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public DataAccessException(String message) {
		super(message );
	}
	
   /** This constructor is used when only cause is used to report the exception.
    * 
    * @param cause
    */
	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	
	
}
