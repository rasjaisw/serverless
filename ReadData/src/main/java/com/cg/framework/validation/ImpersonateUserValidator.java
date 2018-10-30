package com.cg.framework.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.framework.base.auth.AuthDTO;
import com.cg.framework.constant.CommonConstant;
import com.cg.framework.exception.ExceptionConstant;
import com.cg.framework.exception.InsufficientPermissionException;
import com.cg.framework.messagehandler.GenericMessageHandler;
import com.cg.framework.util.TerritoryLocal;

/**
 * This class is used to validate all the input fields for impersonate User.
 * 
 * @author anangupt
 *
 */
@Component
public class ImpersonateUserValidator  {
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ImpersonateUserValidator.class);

	@Autowired
	GenericMessageHandler genericMessageHandle;

	/**This class validate and return the action error message when user try to do transaction 
	 * like add/edit in impersonate mode.
	 * 
	 * @param auth
	 * @return
	 */
	public boolean doValidate(AuthDTO auth) {
		
		LOGGER.info("enter::ImpersonateUserValidator::doValidate");
		ActionErrorMessage actionErrorMessage = null;
		// check whether add/edit permission is present
		if (auth.getProfile().isImpersonateUser()) {
			actionErrorMessage = genericMessageHandle.doProcess(CommonConstant.COMMON_MSG.getVal(),
									ExceptionConstant.INSUFFICIENT_PERMSSION.getVal(), MessageData.ERROR,
									TerritoryLocal.getLocal(TerritoryLocal.US));
			LOGGER.error("ImpersonateUserValidator::Impersonate user.");
			throw new InsufficientPermissionException(actionErrorMessage.getErrorMessage());
		}
		LOGGER.info("enter::ImpersonateUserValidator::doValidate");
		return true;
	}


}