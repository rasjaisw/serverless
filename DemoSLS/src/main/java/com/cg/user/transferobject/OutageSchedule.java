package com.cg.user.transferobject;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * This class holds the value of start date time and end date time.
 * 
 * @author arcachar
 *
 */
public class OutageSchedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1003032339365813831L;

	/**
	 * start date and time of outage
	 */
	private Timestamp startDateTime;
	/**
	 * end date and time of outage
	 */
	private Timestamp endDateTime;
	/**
	 * indicates whether outage is in progress
	 */
	private boolean outage;
	/**
	 * outage message
	 */
	private String message;
	/**
	 * indicates whether outage is active or inactive
	 */
	private boolean outageActiveFlag;
	

	/**
	 * 
	 * @return
	 */
	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	/**
	 * 
	 * @param startDateTime
	 */
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * 
	 * @return
	 */
	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	/**
	 * 
	 * @param endDateTime
	 */
	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isOutage() {
		return outage;
	}

	/**
	 * 
	 * @param outage
	 */
	public void setOutage(boolean outage) {
		this.outage = outage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isOutageActiveFlag() {
		return outageActiveFlag;
	}

	public void setOutageActiveFlag(boolean outageActiveFlag) {
		this.outageActiveFlag = outageActiveFlag;
	}

}
