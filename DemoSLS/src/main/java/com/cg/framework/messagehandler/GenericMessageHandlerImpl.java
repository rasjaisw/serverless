package com.cg.framework.messagehandler;

import java.util.Locale;

import org.springframework.stereotype.Component;

import com.cg.framework.validation.ActionErrorMessage;
import com.cg.framework.validation.BusinessMessageHelper;
import com.cg.framework.validation.Message;
import com.cg.framework.validation.MessageData;

/**This Class provide the implementation details of GenericMessageHandler
 * 
 * @author anangupt
 *
 */

@Component
public class GenericMessageHandlerImpl implements GenericMessageHandler {
	
	/**
	 * This method is used to provide  the implementation details of doProcess method for the argument messageCode, messagetype, locale and bundleName.
	 */
	@Override
	public ActionErrorMessage doProcess(String messageCode, String messagetype, Locale locale, String bundleName) {
		BusinessMessageHelper businessMessageHelper =new BusinessMessageHelper();
		return businessMessageHelper.processMessage(locale, messageBuilder(messageCode, messagetype), bundleName);
	}

	/**
	 * This method is used to provide the implementation details of doProcess method for the argument messageCode, messagetype and locale.
	 */
	@Override
	public ActionErrorMessage doProcess(String messageCode, String messagetype, Locale locale) {
		BusinessMessageHelper businessMessageHelper =new BusinessMessageHelper();
		return businessMessageHelper.processMessage(locale, messageBuilder(messageCode, messagetype));
	}
	
	/**This method is used to build the the message object when messageCode and messagetype is passed.
	 * 
	 * @param messageCode
	 * @param messagetype
	 * @return
	 */
	private Message messageBuilder(String messageCode, String messagetype) {
		Message message = new Message();
		MessageData messageData = new MessageData( messageCode, messagetype );
		message.addMessage(messageData);
		return message;
		
	}

	/**
	 * This class will take the custom message property file, and other parameter are same as above.
	 */
	@Override
	public ActionErrorMessage doProcess(String bundleFile, String messageCode, String messagetype, Locale locale) {
		BusinessMessageHelper businessMessageHelper =new BusinessMessageHelper();
		return businessMessageHelper.processMessage(bundleFile, locale, messageBuilder(messageCode, messagetype));
	}

}
