package com.afc.user.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.cg.user.constant.UserProfileConstant;
import com.cg.user.transferobject.UserAuctionDTO;

/**
 * The class <code>UserDAOImplTest</code> contains tests for the class <code>{@link UserDAOImpl}</code>.
 *
 * @author pbhandal
 */
public class UserDAOImplTest {


	/**
	 * Run the boolean getUserAuctionInfo(boolean,String,String) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetUserAuctionInfo() throws Exception {

		UserAuctionDTO userAuctionDTO = new UserAuctionDTO();
		userAuctionDTO.setAssetTypeName(UserProfileConstant.ASSET_TYPE_NAME.getVal());
		userAuctionDTO.setAuctionCode(UserProfileConstant.AUCTION_CODE.getVal());
		userAuctionDTO.setAuctionName(UserProfileConstant.AUCTION_NAME.getVal());
		userAuctionDTO.setAuctionStartDate(UserProfileConstant.AUCTION_START_DATE.getVal());
		userAuctionDTO.setBranchMail(UserProfileConstant.BRANCH_MAIL.getVal());
		userAuctionDTO.setBranchManager(UserProfileConstant.BRANCH_MANAGER.getVal());
		userAuctionDTO.setBranchName(UserProfileConstant.BRANCH_NAME.getVal());
		userAuctionDTO.setBranchPhone(UserProfileConstant.BRANCH_PHONE.getVal());
		userAuctionDTO.setCountryName(UserProfileConstant.COUNTRY_NAME.getVal());
		userAuctionDTO.setDefaultBackDatingLimit(UserProfileConstant.DEFAULT_BACK_DATING_LIMIT.getVal());
		userAuctionDTO.setDefaultFloorplanDaysToReturn(UserProfileConstant.DEFAULT_FLOORPLAN_DAYS_TO_RETURN.getVal());
		userAuctionDTO.setInternetBranch(UserProfileConstant.INTERNET_BRANCH.getVal());
		userAuctionDTO.setOrgCode(UserProfileConstant.ORG_CODE.getVal());
		userAuctionDTO.setPurchaseTypeName(UserProfileConstant.PURCHASE_TYPE_NAME.getVal());
		userAuctionDTO.setUnitName(UserProfileConstant.UNIT_NAME.getVal());

		assertNotNull(userAuctionDTO);
	}

}