package com.cg.user.constant;

/**This enum holds all the constant which are user profile query..
 * 
 * @author anangupt
 *
 */
public enum UserProfileConstant {

	AUCTION_CODE("auction_code"),
	AUCTION_NAME("auction_name"),
	BRANCH_NAME("branch_name"),
	BRANCH_PHONE("branch_phone"),
	BRANCH_MAIL("branch_mail"),
	BRANCH_MANAGER("branch_manager"),
	ASSET_TYPE_NAME("asset_type_name"),
	AUCTION_START_DATE("auction_start_date"),
	COUNTRY_NAME("country_name"),
	DEFAULT_BACK_DATING_LIMIT("default_back_dating_limit"),
	DEFAULT_FLOORPLAN_DAYS_TO_RETURN("default_floorplan_days_to_return"),
	DEFAULT_MAX_SEARCH_RESULTS("default_max_search_results"),
	ORG_CODE("org_code"),
	PURCHASE_TYPE_NAME("purchase_type_name"),
	UNIT_NAME("unit_name"),
	USER_PERMISSION_NAME("user_permission_name"),
	ID("id"),
	INTERNET_BRANCH("internet_branch"),
	ACTIVE_FLAG("active_flag"),
	AUCTION_DEFAULT("auction_default");
	
	private String val;

	UserProfileConstant(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
}
