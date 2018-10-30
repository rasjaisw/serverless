package com.cg.framework.base.auth;

import java.io.Serializable;
import java.util.List;

/**
 * This class represent the User Profile information
 * 
 * @author anangupt
 *
 */
public class UserProfileDTO implements Serializable {

	private static final long serialVersionUID = 3343071188691711873L;

	/**
	 * user first name.
	 * 
	 */
	private String firstName;

	/**
	 * user last name.
	 * 
	 */
	private String lastName;

	/**
	 * user mobile number.
	 * 
	 */
	private String mobilePhone;

	/**
	 * user second email.
	 * 
	 */
	private String secondEmail;

	/**
	 * user second login id.
	 * 
	 */
	private String login;

	/**
	 * user second email.
	 * 
	 */
	private String email;

	/**
	 * account status of the logged-in user.
	 */
	private String accountStatus;

	
	/**
	 * Active status of the logged-in user.
	 */
	private boolean isActive;
	
	/**
	 * account status of the logged-in user.
	 */
	private String userType;

	/**
	 * true if user is an internal user.
	 */
	private boolean internal;
	
	/**
	 * true if user is an internal user.
	 */
	private boolean oktaUserStatus;
	
	/**
	 * true if user is an impersonate User.
	 */
	private boolean impersonateUser;
	
	/**
	 * list of auction associated with user.
	 */
	private List<UserAuction> userAuctions;
	// Audit User -- AK
	/**
	 * User - Created By.
	 */
	private String createdBy;
	
	/**
	 * User - Last Updated By.
	 */
	private String lastUpdatedBy;
	
	/**
	 * User - Created Date and Time.
	 */
	private String createdDateTime;
	
	/**
	 * User - Last Updated Date and Time.
	 */
	private String lastUpdatedDateTime;
	
	/**
	 * OKTA user last login.
	 */
	private String lastLogin;
	
	/**
	* User - Activated Date and Time.
	*/
	private String Activated;
	

	public String getActivated() {
		return Activated;
	}

	public void setActivated(String activated) {
		Activated = activated;
	}

	

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}
	// Audit User -- AK
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isOktaUserStatus() {
		return oktaUserStatus;
	}

	public void setOktaUserStatus(boolean oktaUserStatus) {
		this.oktaUserStatus = oktaUserStatus;
	}

	public boolean isImpersonateUser() {
		return impersonateUser;
	}

	public void setImpersonateUser(boolean impersonateUser) {
		this.impersonateUser = impersonateUser;
	}

	public List<UserAuction> getUserAuctions() {
		return userAuctions;
	}

	public void setUserAuctions(List<UserAuction> userAuctions) {
		this.userAuctions = userAuctions;
	}

	

}
