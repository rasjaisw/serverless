package com.cg.framework.validation;

import java.io.Serializable;
import java.util.List;

/**
 * Class used to encapsulate the Action error message. which hold the list of error messages after the input validation.
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class ActionErrorMessage implements Serializable {
	

	private static final long serialVersionUID = -6328631191443209751L;

	/**
	 * The List of error message after the validation.
	 */
	private List<ErrorMessage> errorMessage;
	
	private boolean error;

	public List<ErrorMessage> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<ErrorMessage> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	
	
 
}
