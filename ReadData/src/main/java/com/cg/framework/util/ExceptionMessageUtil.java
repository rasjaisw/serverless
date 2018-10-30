package com.cg.framework.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.framework.exception.CosmosApiBadRequest;
import com.cg.framework.exception.RestErrorMessage;
import com.cg.framework.validation.ErrorMessage;

/**This class is used to populate constant message param like error code, summary and type to list of error message.
 * 
 * @author anangupt
 *
 */
public class ExceptionMessageUtil {

	/**The constructor is private so that no class is able to create a object of this class.
	 * 
	 */
	private ExceptionMessageUtil(){
		
	}
	/**This method convert the input error code , summary and type to error message object.
	 * 
	 * @param errorCode
	 * @param errorSummary
	 * @param errorType
	 * @return List<ErrorMessage>
	 */
	public static List<ErrorMessage> populateErrorMessage(String errorCode,  String errorSummary, String errorType) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setFaultCode(errorCode);
		errorMessage.setType(errorType);
		errorMessage.setName(errorSummary);
		List<ErrorMessage> errorMessages = new ArrayList<>(1);
		errorMessages.add(errorMessage);
		return errorMessages;
	}
	
	
	/**This method convert the input error code , summary and type to error message object.
	 * 
	 * @param errorCode
	 * @param errorSummary
	 * @param errorType
	 * @return List<ErrorMessage>
	 */
	public static List<ErrorMessage> populateErrorMessage(CosmosApiBadRequest restErrorMessages, String errorType) {
		
		ErrorMessage errorMessage = null;
		List<ErrorMessage> errorMessages = null;
		if(restErrorMessages != null && restErrorMessages.getErrorMessages() !=null && !restErrorMessages.getErrorMessages().isEmpty()) { 
			 errorMessages = new ArrayList<>(restErrorMessages.getErrorMessages().size());
			for (RestErrorMessage restErrorMessage : restErrorMessages.getErrorMessages()) {
				errorMessage = new ErrorMessage();
				errorMessage.setFaultCode(restErrorMessage.getErrorCode());
				errorMessage.setType(errorType);
				errorMessage.setName(restErrorMessage.getSummary());
				errorMessages.add(errorMessage);
				
			}
		}
		return errorMessages;
	}
}
