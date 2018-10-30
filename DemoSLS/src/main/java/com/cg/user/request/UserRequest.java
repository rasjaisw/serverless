package com.cg.user.request;

import java.io.Serializable;
import java.util.Set;

import com.cg.framework.base.BaseRequest;

/**<Strong> This Class is used to hold all the user create and update request.</Strong> 
 * 
 * @author anangupt
 *
 */
public class UserRequest extends BaseRequest implements Serializable{

	private static final long serialVersionUID = 915118192143971046L;

	/**user first name.
	 * 
	 */
	private String firstName;
	
	/**user last name.
	 * 
	 */
	private String lastName;
	
	/**user mobile number.
	 * 
	 */
	private String mobilePhone;
	
	/**user login id.
	 * 
	 */
	private String email;
	
	
	/**user default auction Id.
	 * 
	 */
	private String auctionId;
	
	
	/**user assigned auction.
	 * 
	 */
	private Set<String> auctions;
	
	/**user auction Name.
	 * 
	 */
	private String auctionName;
	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public Set<String> getAuctions() {
		return auctions;
	}

	public void setAuctions(Set<String> auctions) {
		this.auctions = auctions;
	}


	
}
