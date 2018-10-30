package com.cg.framework.messagehandler;

import java.util.Locale;

import com.cg.framework.validation.ActionErrorMessage;

/**This abstraction define the generic method to process common info message.
 * 
 * @author anangupt
 *
 */
		
public interface GenericMessageHandler {

	/**This method is used to take messageCode,  messagetype and Local and return the final message. 
	 * 
	 * @param errorcode
	 * @param messagetype
	 * @param locale
	 * @return ActionErrorMessage
	 */
	public ActionErrorMessage doProcess(String bundleFile, String messageCode, String messagetype,Locale locale ) ;
	
	/**This method is used to take messageCode,  messagetype and Local and return the final message. 
	 * 
	 * @param errorcode
	 * @param messagetype
	 * @param locale
	 * @return ActionErrorMessage
	 */
	public ActionErrorMessage doProcess(String messageCode, String messagetype,Locale locale ) ;
	
	/**This method is used to take messageCode,  messagetype and Local and return the final message. 
	 * 
	 * @param errorcode
	 * @param messagetype
	 * @param locale
	 * @param bundlename
	 * @return ActionErrorMessage
	 */
	public ActionErrorMessage doProcess(String messageCode, String messagetype,Locale locale, String bundlename ) ;
		
}
