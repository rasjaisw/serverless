package com.cg.sls.handler;
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
import com.cg.sls.delegate.ReadDataActionDelegate;
import com.cg.sls.delegate.WriteDataActionDelegate;
import com.cg.sls.request.UserRequest;
import com.cg.sls.response.ReadDataResponse;

/**
 * This class creates the spring context and delegates the call to the
 * microservice
 * 
 * @author arcachar
 *
 */

public class WriteDataHandler extends AbstractBaseHandler<UserRequest> {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(WriteDataHandler.class);
	/**
	 * This method creates the spring context and delegates the call to the
	 * microservice. It takes the input as service request and returns a service
	 * response.
	 * @throws InvalidSessionException 
	 */
	
	@Override
	public ApiGatewayIntegratedResponse doProcess(ApiGatewayIntegratedRequest apiRequest, Context context) throws InvalidSessionException {

		LOGGER.info("enter::WriteDataHandler::handleRequest");
		System.out.println("enter::WriteDataHandler::handleRequest" +apiRequest.getBody());
		ReadDataResponse  readDataResponse = null;
		ApiGatewayIntegratedResponse apiGatewayIntegratedResponse = null;
		UserRequest userRequest = convertInputRequest(apiRequest, UserRequest.class);
		ApplicationContext applicationContext = ApplicationContextUtil.getInstance(SpringConstant.CONFIG_FILE.getVal());
		ActionDelegate<UserRequest, ReadDataResponse> actionDelegate = applicationContext.getBean(WriteDataActionDelegate.class);
		UserRequest userReq = new UserRequest();
		userReq.setInput(apiRequest.getBody());
		LOGGER.info("enter::WriteDataHandler::handleRequest"+userRequest.getInput());
		System.out.println("enter::WriteDataHandler::handleRequest" +userReq.getInput());
		
		readDataResponse =  actionDelegate.delegate(userReq);
		
		apiGatewayIntegratedResponse =  buildSucess(readDataResponse);
		LOGGER.info("exit::WriteDataHandler::handleRequest");
		return apiGatewayIntegratedResponse;

	}

}
