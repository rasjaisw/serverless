package com.cg.framework.constant;

/**
 * Spring constant is used to declare all the constant which are used for Spring related configuration parameters.
 * 
 * @author anangupt
 *
 */
public enum SpringConstant {

	CONFIG_FILE("application-context.xml");
	
	/**Hold the constant property.
	 * 
	 */
	private String val;

	SpringConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
	
}
