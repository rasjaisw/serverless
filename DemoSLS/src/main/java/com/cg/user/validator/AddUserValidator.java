package com.cg.user.validator;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import  com.cg.framework.base.auth.AuthDTO;
import  com.cg.framework.messagehandler.GenericMessageHandler;
import  com.cg.framework.util.TerritoryLocal;
import  com.cg.framework.validation.ActionErrorMessage;
import com.cg.framework.validation.MessageData;
import com.cg.framework.validation.Validator;
import com.cg.user.constant.MessageConstant;
import com.cg.user.request.UserRequest;

/**
 * This class is used to validate all the input fields for add User.
 * 
 * @author anangupt
 *
 */
@Component
public class AddUserValidator implements Validator<UserRequest> {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AddUserValidator.class);

	/**
	 * This service is used to process business message.
	 * 
	 */
	@Autowired
	GenericMessageHandler genericMessageHandler;

	@Override
	public ActionErrorMessage doValidate(UserRequest userRequest, AuthDTO authDTO) {
		
		LOGGER.info("enter::UserProfileValidator::doValidate");
		// check whether all the fields are provided.
		ActionErrorMessage actionErrorMessage = null;

		if (StringUtils.isBlank(userRequest.getFirstName())) {
			LOGGER.error("AddUserActionDelegate::doValidation:: FirstName is blank.");
			return processValidation(MessageConstant.UA0026.val(), MessageData.ERROR, TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		if (StringUtils.isBlank(userRequest.getLastName())) {
			LOGGER.error("AddUserActionDelegate::doValidation::Last Name is blank.");
			return processValidation(MessageConstant.UA0029.val(), MessageData.ERROR, TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		if (StringUtils.isBlank(userRequest.getEmail())) {
			LOGGER.error("AddUserActionDelegate::doValidation::invalid email id");
			return processValidation(MessageConstant.UA0010.val(), MessageData.ERROR,TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		if (StringUtils.isBlank(userRequest.getMobilePhone())) {
			LOGGER.error("AddUserActionDelegate::doValidation::mobile number is blank.");
			return genericMessageHandler.doProcess(MessageConstant.UA0030.val(), MessageData.ERROR,
					TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		if( userRequest.getAuctions()==null || userRequest.getAuctions().isEmpty()) {
			LOGGER.error("AddUserActionDelegate::validateUser::select atleast one auction.");
			return processValidation(MessageConstant.UA0011.val(), MessageData.ERROR,	TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		
	    if( StringUtils.isBlank(userRequest.getAuctionId())) {
	    	LOGGER.error("AddUserActionDelegate::validateUser::select default one auction.");
	    	return processValidation(MessageConstant.UA0027.val(), MessageData.ERROR,	TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		
	    
	    if( !userRequest.getAuctions().contains(userRequest.getAuctionId())) {
	    	LOGGER.error("AddUserActionDelegate::validateUser::selected default auction does not exist in selected auctions.");
	    	return processValidation(MessageConstant.UA0028.val(), MessageData.ERROR,	TerritoryLocal.getLocal(TerritoryLocal.US));
		}
		
	    LOGGER.info("exit::UserProfileValidator::doValidate");
		return actionErrorMessage;

	}

	private ActionErrorMessage processValidation(String messageCode, String messageType, Locale locale) {
		return genericMessageHandler.doProcess(messageCode, messageType, locale);

	}

}