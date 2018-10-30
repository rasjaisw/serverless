package com.cg.framework.exception;

import java.io.Serializable;

/**This class is used when there is a HTTP 400 exception from calling the REST API.
 * 
 * @author anangupt
 *
 */
public class RestErrorMessage implements Serializable {


	
	
	private static final long serialVersionUID = -6432248706702724487L;

	/**
	 * Error code of the response
	 * 
	 */
	private String errorCode;

	/**
	 * Error cause.
	 * 
	 */
	private String errorCause;
	
	/**
	 * Error summary.
	 * 
	 */
	private String summary;

	/**
	 * Error link of the validation response
	 * 
	 */
	private String errorLink;

	/**
	 * Error id of the validation response.
	 * 
	 */
	private String errorId;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getErrorLink() {
		return errorLink;
	}

	public void setErrorLink(String errorLink) {
		this.errorLink = errorLink;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	
	
}
