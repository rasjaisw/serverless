package com.cg.framework.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the information of a parameter used in Message.
 * 
 * @author Anand Gupta
 * @version 1.0
 */
public class ParamInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892165195923470064L;

	/**
	 * Used to hold the value of message.
	 * 
	 */
	private String value;

	/**
	 * Used to hold the value of key.
	 * 
	 */
	private String key;
	/**
	 * Used to hold the value of list key.
	 * 
	 */
	private List<String> keys = new ArrayList<>(1);
	/**
	 * Used to hold the value of list which will not picked from Resource bundle,
	 *  i.e., Constacnt values, which will showed as comma seperated.
	 * 
	 */
	private List<String> values = new ArrayList<String>(1);

	public ParamInfo(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public ParamInfo( String value ) {
		this.value = value;
	}
	public ParamInfo(List<String> values ) {
		this.values = values;
	}
	public String getKey() {
		return key;
	}

	public ParamInfo() {
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}


}
