package com.cg.user.transferobject;

import java.io.Serializable;
import java.util.List;

import  com.cg.framework.base.auth.UserAuction;

public class UserAndStatus implements Serializable{

	private static final long serialVersionUID = -8562527180947411692L;
	
	/**User id of the user.
	 * 
	 */
	private String userId;
	
	/**user active status.
	 * 
	 */
	boolean isActive;

	/**Auction belongs to user.
	 * 
	 */
	private List<UserAuction> auctions;
	// Audit User -- AK
	/**created_by of the user.
	 * 
	 */
	private String created_by;
	
	/**last_updated_by of the user.
	 * 
	 */
	private String last_updated_by;
	
	/**created_datetime of the user.
	 * 
	 */
	private String created_datetime;
	
	/**last_updated_datetime of the user.
	 * 
	 */
	private String last_updated_datetime;
	
	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public String getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}

	public String getLast_updated_datetime() {
		return last_updated_datetime;
	}

	public void setLast_updated_datetime(String last_updated_datetime) {
		this.last_updated_datetime = last_updated_datetime;
	}
	// Audit User -- AK
	
	public UserAndStatus(String userId, boolean isActive, String created_by, String last_updated_by, String created_datetime, String last_updated_datetime) {
		super();
		this.userId = userId;
		this.isActive = isActive;
		// Audit User -- AK
		this.created_by = created_by;
		this.last_updated_by = last_updated_by;
		this.created_datetime = created_datetime;
		this.last_updated_datetime = last_updated_datetime;
		// Audit User -- AK
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<UserAuction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<UserAuction> auctions) {
		this.auctions = auctions;
	}

	
	

}
