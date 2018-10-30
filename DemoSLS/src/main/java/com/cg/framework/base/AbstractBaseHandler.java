package com.cg.framework.base;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cg.framework.base.auth.AuthObject;
import com.cg.framework.constant.CommonConstant;
import com.cg.framework.constant.SpringConstant;
import com.cg.framework.exception.ExceptionConstant;
import com.cg.framework.exception.InsufficientPermissionException;
import com.cg.framework.exception.InvalidSessionException;
import com.cg.framework.lambda.apigateway.ApiGatewayIntegratedRequest;
import com.cg.framework.lambda.apigateway.ApiGatewayIntegratedResponse;
import com.cg.framework.util.ApplicationContextUtil;
import com.cg.framework.util.ExceptionMessageUtil;
import com.cg.framework.util.JsonUtil;
import com.cg.framework.validation.ErrorMessage;
import com.cg.framework.validation.MessageData;

/**
 * This class contains the common logic to convert the input request also
 * building the success and failure response.
 * 
 * @author anangupt
 *
 */
public abstract class AbstractBaseHandler<T extends BaseRequest> implements RequestHandler<ApiGatewayIntegratedRequest, ApiGatewayIntegratedResponse> {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractBaseHandler.class);
	
	private static final String RANDOM_ID = String.format("%05d",  new Random().nextInt(100000));
	
	enum HTTPHeaderConstant {

		ACCESS_CONTROL_ALLOW_ORIGIN("access-control-allow-origin"),
		ACCESS_CONTROL_ALLOW_ORIGIN_VAL("*");
		
		private String val;

		HTTPHeaderConstant(String val){
			this.val = val;
		}
		
		public String getVal() {
			return this.val;
		}
	}

	public static final int HTTP_CODE_200 = 200;
	
	public static final int HTTP_CODE_503 = 503;
	
	/**
	 * This is the enttry point of a Lambda microservice
	 * This method checks for warmup requests and delegates to doProcess
	 * 
	 * @author arcachar
	 *
	 */	
	public ApiGatewayIntegratedResponse handleRequest(ApiGatewayIntegratedRequest apiRequest, Context context) {
		
		
		LOG.info("Request Received by Instance :{} ",RANDOM_ID );
		BaseResponse baseResponse  = null;
		if (isWarmupRequest(apiRequest)) {
			LOG.info("Warmup initiated");
			loadApplicationContext();
			return null;
		}
		LOG.info("Enter : AbstractBaseHandler :: handleRequest");
		ApiGatewayIntegratedResponse response = null;
		try {
			response = doProcess(apiRequest, context);
			LOG.info("exit::AbstractBaseHandler::handleRequest");
		} catch (InsufficientPermissionException exception) {
			response = buildExceptionResponse(exception);
		} catch (InvalidSessionException exception) {
			baseResponse = new BaseResponse();
			baseResponse.setErrorMessages(exception.getErrorMessage());
			response =  buildSucess(baseResponse);
		}catch (Exception e) {
			LOG.error("AbstractBaseHandler :: ERROR IN ApiGatewayIntegratedResponse {}", e);
			baseResponse = new BaseResponse();
			List<ErrorMessage> messages = ExceptionMessageUtil.populateErrorMessage(
					ExceptionConstant.GENERAL_EXCEPTION_CODE.getVal(),
					ExceptionConstant.GENERAL_EXCEPTION_CODE_SUMMARY.getVal(), MessageData.ERROR);
			baseResponse.setErrorMessages(messages);
			response =  buildSucess(baseResponse);
		}
		
		return response;
	}

	/**This method is used to build exception response.
	 * 
	 * @param exception
	 * @return
	 */
	private ApiGatewayIntegratedResponse buildExceptionResponse(InsufficientPermissionException exception) {
		
		BaseResponse baseResponse = new BaseResponse();
		ApiGatewayIntegratedResponse response;
		baseResponse.setErrorMessages(exception.getErrorMessage());
		response =  buildSucess(baseResponse);
		return response;
	}
	
	/**
	 * This is the "real" entry point for Lambda microservice after the warmup check
	 * It is abstract and needs to be implemented by concrete sub-classes
	 * @author arcachar
	 *
	 */	
	protected abstract ApiGatewayIntegratedResponse doProcess(ApiGatewayIntegratedRequest apiRequest, Context context) throws InvalidSessionException;
	
	
	
	/**This class is used to convert the input RAW request to application module specific request object.
	 * 
	 * @param apiRequest
	 * @param reqClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T convertInputRequest(ApiGatewayIntegratedRequest apiRequest, Class<T> reqClass) {

		T request = JsonUtil.convertToObject(apiRequest.getBody(), reqClass);
		AuthObject authObject = convertAuthObject(apiRequest);
		if(request==null) {
			try {
				request = (T)Class.forName(reqClass.getName()).newInstance();
				request.setAuthObject(authObject);
			} catch (Exception e) {
				LOG.error("Unable to create object", e);
			} 
		}else {
			request.setAuthObject(authObject);
		}
		return request;
	}
	
	
	/**This Method is used to check for warmup requests.
	 * 
	 * @param apiRequest
	 * @return
	 */
	protected boolean isWarmupRequest(ApiGatewayIntegratedRequest apiRequest) {
		if (apiRequest != null) {
			return ("WarmUpRequest".equalsIgnoreCase(apiRequest.getBody()));
		}
		return false;
	}
	
	
	/**This method extract the auth header passed to the microservice in headers.
	 * 
	 * @param apiRequest
	 * @return
	 */
	private AuthObject convertAuthObject(ApiGatewayIntegratedRequest apiRequest) {
		AuthObject authObject = new AuthObject();
		if(apiRequest.getHeaders() !=null && apiRequest.getHeaders().get(CommonConstant.AUTHORIZATION_ID.getVal())!=null ) {
			authObject.setAuthorizationId(apiRequest.getHeaders().get(CommonConstant.AUTHORIZATION_ID.getVal()));
		}
		return authObject;
	}

	/**This method build the HTTP Code 200 response in case of successful execution of the request.
	 * 
	 * @param res
	 * @return
	 */
	public ApiGatewayIntegratedResponse buildSucess(Object response) {

		return buildResponse(response, HTTP_CODE_200 );
	}

	/**This method build the HTTP Code 503 response in case of successful execution of the request.
	 * 
	 * @param res
	 * @return
	 */
	public ApiGatewayIntegratedResponse buildFailure(Object response) {
		
		return buildResponse(response, HTTP_CODE_503 );
	}

	/**This method build response for passed response object and HTTP Code status code.
	 * 
	 * @param response
	 * @param errorCode
	 * @return
	 */
	private ApiGatewayIntegratedResponse buildResponse(Object response, int errorCode) {
		return ApiGatewayIntegratedResponse.builder().setStatusCode(errorCode).setObjectBody(response)
				.setHeaders(Collections.singletonMap(HTTPHeaderConstant.ACCESS_CONTROL_ALLOW_ORIGIN.getVal(),
						HTTPHeaderConstant.ACCESS_CONTROL_ALLOW_ORIGIN_VAL.getVal()))
				.build();
	}
	
	/**The default implementation of loadconfig method, the child class object can overrride this method to give the implemetation
	 * for better performance and load the bean eagerly.
	 * 
	 * @author anangupt
	 *
	 */	
	protected Object loadApplicationContext() {
		ApplicationContextUtil.getInstance(SpringConstant.CONFIG_FILE.getVal());
		return null; 
	}
}
