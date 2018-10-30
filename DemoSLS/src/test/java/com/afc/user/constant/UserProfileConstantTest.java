package com.afc.user.constant;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.user.constant.UserProfileConstant;

import static org.junit.Assert.*;

/**
 * The class <code>UserProfileConstantTest</code> contains tests for the class
 * <code>{@link UserProfileConstant}</code>.
 * 
 * @author satipati
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class UserProfileConstantTest {

	/**
	 * Run the String.getVal() method test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testUserProfileConstantVal() throws Exception {

		UserProfileConstant userProfileConstant = null;

		userProfileConstant = UserProfileConstant.AUCTION_CODE;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.AUCTION_NAME;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.BRANCH_NAME;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.BRANCH_PHONE;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.BRANCH_MAIL;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.BRANCH_MANAGER;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.ASSET_TYPE_NAME;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.AUCTION_START_DATE;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.COUNTRY_NAME;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.DEFAULT_BACK_DATING_LIMIT;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.DEFAULT_FLOORPLAN_DAYS_TO_RETURN;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.DEFAULT_MAX_SEARCH_RESULTS;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.ORG_CODE;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.PURCHASE_TYPE_NAME;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.UNIT_NAME;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.USER_PERMISSION_NAME;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.ID;
		assertNotNull(userProfileConstant.getVal());
		
		userProfileConstant = UserProfileConstant.INTERNET_BRANCH;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.ACTIVE_FLAG;
		assertNotNull(userProfileConstant.getVal());

		userProfileConstant = UserProfileConstant.AUCTION_DEFAULT;
		assertNotNull(userProfileConstant.getVal());

	}

	
}