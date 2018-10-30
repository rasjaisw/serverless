package com.cg.user.transferobject;

import java.io.Serializable;

/**This class holds the value of id and name of auction.
 * 
 * @author anangupt
 *
 */
public class Auction implements Serializable{

	private static final long serialVersionUID = 732746572317965199L;
	
	/**Auction id in db.
	 * 
	 */
	private String auctionId;
	
	/**Auction name in db.
	 * 
	 */
	private String auctionName;

	
	public Auction() {
		super();
	}
	
	public Auction(String auctionId, String auctionName) {
		super();
		this.auctionId = auctionId;
		this.auctionName = auctionName;
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
	
	

}
