package com.cg.user.token;

import java.util.UUID;
/**This class is used to generate the unique token
 * 
 * @author anangupt
 *
 */
		
public class TokenGenerator {

	/**Private constructor is used to prevent to create object of this class.
	 * 
	 */
	private TokenGenerator() {
		
	}
	
	/**This method is used to generate the new token every time.
	 * 
	 * @return String
	 */
	public static final String getToken(){
		return String.valueOf(UUID.randomUUID());
	}
}
