package com.cg.framework.base.auth;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.framework.base.BaseDTO;

/**This class used to carry the auth parameter like userid and roles which is used to authorize when request
 * come to lambda.
 * 
 * @author anangupt
 *
 */
public class AuthDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -644420902434509843L;
	
	/**
	 * holds the user profile information.
	 */
	private UserProfileDTO profile;

	/**This fields indicates whether the authentication is success is not.
	 * 
	 */
	private boolean authenticate;
	
	
	/**
	 * holds the list of permission.
	 */
	private Set<String> permissions;
	
	/**
	 * holds the map of auction permission.
	 */
	private Map<String,Set<String>> auctionPermissionsMap;
	
	/**
	 * holds user default auction Detail.
	 */
	private UserAuction userAuction;
	
	/**
	 * hold the list of user assigned auctions.
	 */
	private List<UserAuction> userAuctions;
	
    /**Logged in time.
     * 
     */
    private String loginTime;
    

	public UserProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(UserProfileDTO profile) {
		this.profile = profile;
	}

	public boolean isAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public UserAuction getUserAuction() {
		return userAuction;
	}

	public void setUserAuction(UserAuction userAuction) {
		this.userAuction = userAuction;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public List<UserAuction> getUserAuctions() {
		return userAuctions;
	}

	public void setUserAuctions(List<UserAuction> userAuctions) {
		this.userAuctions = userAuctions;
	}

	public Map<String, Set<String>> getAuctionPermissionsMap() {
		return auctionPermissionsMap;
	}

	public void setAuctionPermissionsMap(Map<String, Set<String>> auctionPermissionsMap) {
		this.auctionPermissionsMap = auctionPermissionsMap;
	}


	
}
