package com.cg.framework.constant;

/**
 * Spring constant is used to declare all the constant which are used for Spring related configuration parameters.
 * 
 * @author anangupt
 *
 */
public enum CommonConstant {

	AUTHORIZATION_ID("Authorization"),
	INTERNAL_USER("INTERNAL"),
	COMMON_MSG("common"),
	EXTERNAL_USER("EXTERNAL"),
	ORG_ID("22"),
	ORG_NAME("AUCTION PORTAL");
	
	/**Hold the constant property.
	 * 
	 */
	private String val;

	CommonConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
	
}
