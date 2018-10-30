package com.cg.user.handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.cg.framework.base.AbstractBaseHandler;
import com.cg.framework.base.delegate.ActionDelegate;
import com.cg.framework.constant.SpringConstant;
import com.cg.framework.exception.InvalidSessionException;
import com.cg.framework.lambda.apigateway.ApiGatewayIntegratedRequest;
import com.cg.framework.lambda.apigateway.ApiGatewayIntegratedResponse;
import com.cg.framework.util.ApplicationContextUtil;
import com.cg.user.delegate.AddUserActionDelegate;
import com.cg.user.request.UserRequest;
import com.cg.user.response.UserResponse;

/**
 * This class creates the spring context and delegates the call to the
 * microservice
 * 
 * @author arcachar
 *
 */

public class AddUserHandler extends AbstractBaseHandler<UserRequest> {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AddUserHandler.class);
	/**
	 * This method creates the spring context and delegates the call to the
	 * microservice. It takes the input as service request and returns a service
	 * response.
	 * @throws InvalidSessionException 
	 */
	
	@Override
	public ApiGatewayIntegratedResponse doProcess(ApiGatewayIntegratedRequest apiRequest, Context context) throws InvalidSessionException {

		LOGGER.info("enter::AddUserHandler::handleRequest");
		UserResponse  userResponse = null;
		ApiGatewayIntegratedResponse apiGatewayIntegratedResponse = null;
		UserRequest userRequest = convertInputRequest(apiRequest, UserRequest.class);
		ApplicationContext applicationContext = ApplicationContextUtil.getInstance(SpringConstant.CONFIG_FILE.getVal());
		ActionDelegate<UserRequest, UserResponse> actionDelegate = applicationContext.getBean(AddUserActionDelegate.class);
		userResponse =  actionDelegate.delegate(userRequest);
		
		apiGatewayIntegratedResponse =  buildSucess(userResponse);
		LOGGER.info("exit::AddUserHandler::handleRequest");
		return apiGatewayIntegratedResponse;

	}

}
