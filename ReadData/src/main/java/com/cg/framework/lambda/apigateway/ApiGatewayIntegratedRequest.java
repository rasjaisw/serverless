package com.cg.framework.lambda.apigateway;

import java.util.Map;

/**This class is represent the API gateway integrated request.
 * 
 * @author anangupt
 *
 */
public class ApiGatewayIntegratedRequest {

	/**This property represent the resource which is asked in input request.
	 */
	private String resource;
	
	/**This represent the URI of the request.
	 */
    private String path;
   
    /**This property tell about the HTTP verb like GET, POST etc..
     */
    private String httpMethod;

    /**This property holds all the headers which are passed from UI or request.
     */
    private Map<String, String> headers;
    
    /**This property holds all query parameters passed from UI or request.
     */
    private Map<String, String> queryStringParameters;
    
    /**This property holds path parameter.
     */
    private Map<String, String> pathParameters;
    
    /**This property represent the AWS stage value .
     */
    private Map<String, String> stageVariables;
    
    /**This property represent the AWS request Context .
     */
    private ApiGatewayRequestContext requestContext;
    
    /**This property holds the input in a json format.
     */
    private String body;
    
   
    
    /**This property tells whether the request is Base64 encoded.
     */
    private boolean isBase64Encoded;
    
    
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public Map<String, String> getQueryStringParameters() {
		return queryStringParameters;
	}
	public void setQueryStringParameters(Map<String, String> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}
	public Map<String, String> getPathParameters() {
		return pathParameters;
	}
	public void setPathParameters(Map<String, String> pathParameters) {
		this.pathParameters = pathParameters;
	}
	public Map<String, String> getStageVariables() {
		return stageVariables;
	}
	public void setStageVariables(Map<String, String> stageVariables) {
		this.stageVariables = stageVariables;
	}
	public ApiGatewayRequestContext getRequestContext() {
		return requestContext;
	}
	public void setRequestContext(ApiGatewayRequestContext requestContext) {
		this.requestContext = requestContext;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}
	public void setBase64Encoded(boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}
    
}
