package com.cg.user.transferobject;

import java.io.Serializable;
import java.util.Set;

/**
 * This class will contain the auction details and related branch details for
 * the user.
 * 
 * @author arcachar
 *
 */
public class UserAuctionDTO implements Serializable {

	private static final long serialVersionUID = 6080270424140706625L;

	/**
	 * auction name
	 */
	private String auctionName;
	/**
	 * auction code
	 */
	private String auctionCode;
	/**
	 * user's associated AFC branch name for the auction
	 */
	private String branchName;
	/**
	 * AFC branch manager name
	 */
	private String branchManager;
	/**
	 * AFC branch phone
	 */
	private String branchPhone;
	/**
	 * AFC branch mail
	 */
	private String branchMail;

	/**
	 * default asset type on the create floorplan page
	 */
	private String assetTypeName;
	/**
	 * org code for the auction
	 */
	private String orgCode;
	/**
	 * default back dating limit on the create floorplan page
	 */
	private String defaultBackDatingLimit;
	/**
	 * default unit of measurement on the create floorplan page
	 */
	private String unitName;
	/**
	 * default country id for the auction
	 */
	private String countryName;
	/**
	 * default no. of floor plan days to return on the payment status page
	 */
	private String defaultFloorplanDaysToReturn;
	/**
	 * auction start date to return on the payment status page
	 */
	private String auctionStartDate;
	/**
	 * default no of search result to be returned.
	 */
	private String defaultMaxSearchResults;
	/**
	 * default purchase type id of the auction.
	 */
	private String purchaseTypeName;
	/**
	 * internet branch flag.
	 */
	private String internetBranch;
	/**
	 * indicates whether the user is active in RDS
	 */
	private String activeFlag;
	
	/**
	 * holds the list of auction permissions.
	 */
	private Set<String> permissions;
	
	/**
	 * This filed indicate whether this is a default auction..
	 */
	private boolean defaultAuction;
	
	

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * 
	 * @return
	 */
	public String getInternetBranch() {
		return internetBranch;
	}

	/**
	 * 
	 * @param internetBranch
	 */
	public void setInternetBranch(String internetBranch) {
		this.internetBranch = internetBranch;
	}

	/**
	 * 
	 * @return
	 */
	public String getAuctionName() {
		return auctionName;
	}

	/**
	 * 
	 * @param auctionName
	 */
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	/**
	 * 
	 * @return
	 */
	public String getAuctionCode() {
		return auctionCode;
	}

	/**
	 * 
	 * @param auctionCode
	 */
	public void setAuctionCode(String auctionCode) {
		this.auctionCode = auctionCode;
	}

	/**
	 * 
	 * @return
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * 
	 * @param branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * 
	 * @return
	 */
	public String getBranchManager() {
		return branchManager;
	}

	/**
	 * 
	 * @param branchManager
	 */
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}

	/**
	 * 
	 * @return
	 */
	public String getBranchPhone() {
		return branchPhone;
	}

	/**
	 * 
	 * @param branchPhone
	 */
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDefaultBackDatingLimit() {
		return defaultBackDatingLimit;
	}

	public void setDefaultBackDatingLimit(String defaultBackDatingLimit) {
		this.defaultBackDatingLimit = defaultBackDatingLimit;
	}

	public String getDefaultFloorplanDaysToReturn() {
		return defaultFloorplanDaysToReturn;
	}

	public void setDefaultFloorplanDaysToReturn(String defaultFloorplanDaysToReturn) {
		this.defaultFloorplanDaysToReturn = defaultFloorplanDaysToReturn;
	}

	public String getAuctionStartDate() {
		return auctionStartDate;
	}

	public void setAuctionStartDate(String auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	public String getDefaultMaxSearchResults() {
		return defaultMaxSearchResults;
	}

	public void setDefaultMaxSearchResults(String defaultMaxSearchResults) {
		this.defaultMaxSearchResults = defaultMaxSearchResults;
	}

	public String getAssetTypeName() {
		return assetTypeName;
	}

	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPurchaseTypeName() {
		return purchaseTypeName;
	}

	public void setPurchaseTypeName(String purchaseTypeName) {
		this.purchaseTypeName = purchaseTypeName;
	}

	public String getBranchMail() {
		return branchMail;
	}

	public void setBranchMail(String branchMail) {
		this.branchMail = branchMail;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public boolean isDefaultAuction() {
		return defaultAuction;
	}

	public void setDefaultAuction(boolean defaultAuction) {
		this.defaultAuction = defaultAuction;
	}
	
	

}
