package com.cg.framework.util;

/** This Util class help to read and return the AWS environment variable.
 * 
 * @author anangupt
 *
 */
public class AWSEnvironmentUtil {

	/**Private constructor so that no class can make a object of this class.
	 * 
	 */
	private AWSEnvironmentUtil() {
		
	}
	
	/**This method return the value for the AWS environment key.
	 * 
	 * @param envKey
	 * @return String
	 */
	public static String getValue(String envKey) {
		
		return System.getenv(envKey);
	}
	
	
}
