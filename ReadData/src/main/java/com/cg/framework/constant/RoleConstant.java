package com.cg.framework.constant;

/** * @author anangupt
 * 
 * This Enum holds all the permission name;
 *
 */
public enum RoleConstant {

	VIEW_FLOOR_UNIT("View Floor Unit"),
	SUBMIT_FLOOR_UNIT("Submit Floor Unit"),
	ADD_EDIT_USERS("Add/Edit Users"),
	DEACTIVATE_USER("Deactivate User"),
	IMPERSONATE_USER("Impersonate User"),
	SEND_PASSWORD_RESET_EMAIL("Send Password Reset Email"),
	SITE_ADMINISTRATION("Site Administration");
	
	private RoleConstant(String val) {
		this.val = val;
	}
	
	private String val;

	public String getVal() {
		return val;
	}
	
}

