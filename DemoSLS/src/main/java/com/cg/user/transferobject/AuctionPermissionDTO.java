package com.cg.user.transferobject;

import java.io.Serializable;

public class AuctionPermissionDTO implements Serializable {

	private static final long serialVersionUID = -4189973131391832770L;

	private String auctionId;
	
	private String permission;
	
	private boolean defaultAuction;

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean isDefaultAuction() {
		return defaultAuction;
	}

	public void setDefaultAuction(boolean defaultAuction) {
		this.defaultAuction = defaultAuction;
	}


	
	
	
	
}
