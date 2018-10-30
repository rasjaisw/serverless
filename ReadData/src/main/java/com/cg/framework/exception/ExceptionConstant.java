package com.cg.framework.exception;

/**
 * Spring constant is used to declare all the constant which are used for Spring related configuration parameters.
 * 
 * @author anangupt
 *
 */
public enum ExceptionConstant {

	REST_CLIENT_CONNECTION_CODE("RC0001"),
	REST_CLIENT_CONNECTION_SUMMARY("Host System is Down. Please Contact Your Administrator"),
	GENERAL_EXCEPTION_CODE("GE0001"),
	GENERAL_EXCEPTION_CODE_SUMMARY("System is Down. Please Contact Your Administrator"),
	INSUFFICIENT_PERMSSION("FW0003");
	
	/**Hold the constant property.
	 * 
	 */
	private String val;

	ExceptionConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
	
}
