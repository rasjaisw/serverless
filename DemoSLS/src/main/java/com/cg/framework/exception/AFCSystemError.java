package com.cg.framework.exception;


import java.io.Serializable;
import java.util.Date;


/**This class is used to store or send the exception trace and issue to DB, Cache or File system.
 * 
 * @author anangupt
 *
 */
public class AFCSystemError implements Serializable {
	

	private static final long serialVersionUID = -7149194020726507852L;
	
	private Long exceptionLogId;
	private String businessEntity;
	private Long businessId;
	private String className;
	private String errorDescription;
	private String exceptionType;
	private String methodName;
	private String stackTrace;
	private Date timeStamp;
	private String userName;

	public Long getExceptionLogId() {
		return exceptionLogId;
	}

	public void setExceptionLogId(Long exceptionLogId) {
		this.exceptionLogId = exceptionLogId;
	}

	public String getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(String businessEntity) {
		this.businessEntity = businessEntity;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
