package com.cg.sls.constant;

/**This enum holds all the constant which are used for email configuration.
 * 
 * @author pritpalk
 *
 */
public enum MailConstant {

		MAIL_SMTP_AUTH("mail.smtp.auth"),
		MAIL_SMTP_STARTTLS_ENABLE("mail.smtp.starttls.enable"),
		MAIL_SMTP_HOST("mail.smtp.host"),
		MAIL_SMTP_PORT("mail.smtp.port"),
		MAIL_SMTP_SSL_TRUST("mail.smtp.ssl.trust"),		
		FORGOT_PASSWORD_MAIL_SUBJECT("Account Password Reset Requested"),
		ADD_USER_MAIL_SUBJECT("Welcome to www.floorwithafc.com!"),		
		AFC_URL("www.floorwithafc.com "),
		FROM_ID("noreply@autofinance.com"),
		AFC_SIGN_UP_URL("https://www.floorwithafc.com"),
		WELCOME_MESSAGE("Welcome to"),
		CONTENT_TYPE_HTML("text/html; charset=utf-8"),
		CHAR_TYPE_UTF("charset=utf-8");
		
	
	
		private String value;

		MailConstant (String property) {
			this.value = property;
		}

		public String val() {
			return value;
		}
	
}
