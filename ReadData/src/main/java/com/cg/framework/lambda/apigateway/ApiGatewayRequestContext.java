package com.cg.framework.lambda.apigateway;

import java.io.Serializable;

/**This class is used to hold AWS context properties.
 * 
 * @author anangupt
 *
 */
public class ApiGatewayRequestContext implements Serializable{

	private static final long serialVersionUID = 8214107467461585171L;
	private String accountId;
    private String resourceId;
    private String stage;
    private String requestId;
    private ApiGatewayIdentity identity;
    private String resourcePath;
    private String httpMethod;
    private String apiId;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public ApiGatewayIdentity getIdentity() {
		return identity;
	}
	public void setIdentity(ApiGatewayIdentity identity) {
		this.identity = identity;
	}
	public String getResourcePath() {
		return resourcePath;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
    
}
