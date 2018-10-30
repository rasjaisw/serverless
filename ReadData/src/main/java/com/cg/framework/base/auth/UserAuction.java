package com.cg.framework.base.auth;

import java.io.Serializable;

/** holds the user specific information for the Auction.
 * 
 * @author anangupt
 *
 */
public class UserAuction implements Serializable {

	private static final long serialVersionUID = -8838421504974848064L;
	
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
	 * Internet Branch of the auction.
	 */
	private String internetBranch;
	
	/**
	 * default auction.
	 */
	private boolean defaultAuction;
	
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public String getAuctionCode() {
		return auctionCode;
	}
	public void setAuctionCode(String auctionCode) {
		this.auctionCode = auctionCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}
	public String getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getAssetTypeName() {
		return assetTypeName;
	}
	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
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
	public String getPurchaseTypeName() {
		return purchaseTypeName;
	}
	public void setPurchaseTypeName(String purchaseTypeName) {
		this.purchaseTypeName = purchaseTypeName;
	}
	public String getInternetBranch() {
		return internetBranch;
	}
	public void setInternetBranch(String internetBranch) {
		this.internetBranch = internetBranch;
	}
	public boolean isDefaultAuction() {
		return defaultAuction;
	}
	public void setDefaultAuction(boolean defaultAuction) {
		this.defaultAuction = defaultAuction;
	}
	
	

}
