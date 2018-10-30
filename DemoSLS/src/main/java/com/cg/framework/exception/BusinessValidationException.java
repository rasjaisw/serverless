package com.cg.framework.exception;

import com.cg.framework.validation.Message;

/**This exception is thrown when the input criteria is not met or there is a issue 
 * in issue in input is provided to process. The main use of this class is in request
 * validation.
 * 
 * @author anangupt
 *
 */
public class BusinessValidationException extends Exception {

	private static final long serialVersionUID = 6514861435836452010L;
	
	/**Hold the message object which is raised while validation.
	 * 
	 */
	private final Message messages;

	public BusinessValidationException(Message message) {
		super();
		this.messages = message;
	}

	public Message getMessages() {
		return messages;
	}


	
}
