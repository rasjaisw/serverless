package com.cg.user.transferobject;

/**This class is used to hold forgot password response from the okta.
 * 
 * @author anangupt
 *
 */
public class ForgotPasswordDTO {

	/**Password link sent by okta on success.
	 * 
	 */
	private String resetPasswordUrl;

	public String getResetPasswordUrl() {
		return resetPasswordUrl;
	}

	public void setResetPasswordUrl(String resetPasswordUrl) {
		this.resetPasswordUrl = resetPasswordUrl;
	}
	
	
}
