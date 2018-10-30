package com.cg.framework.validation;

import java.io.Serializable;

/**
 * Class used to encapsulate the message String , type and color. Which will
 * display to user as a warning, success and error.
 *
 * @author Anand Gupta
 * @version 1.1
 */
public class ErrorMessage implements Serializable {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 7077224999703972229L;

	private String identifier;

	/**
	 * used to show message String.
	 */
	private String name;
	/**
	 * used to show message String.
	 */
	private int id;
	/**
	 * used to show message type.
	 */
	private String type;
	
	/**
	 * used to show fault code.
	 */
	private String faultCode;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String name) {
		super();
		this.name = name;
	}

	public ErrorMessage(String name, String type, String faultCode) {
		super();
		this.name = name;
		this.type = type;
		this.faultCode = faultCode;
	}


	public ErrorMessage(String name, int id, String type, String idfier) {
		super();
		if (id > 0) {
			this.name = id + "." + name;
		} else {
			this.name = name;
		}
		this.id = id;
		this.type = type;
		this.identifier = idfier;
	}

	public ErrorMessage(String name, int id, String type) {
		super();
		if (id > 0) {
			this.name = id + "." + name;
		} else {
			this.name = name;
		}
		this.id = id;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	
	

}
