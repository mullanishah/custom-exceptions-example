package com.core.exceptions;

public class AccountHandlingException extends Exception {
	
	private static final long serialVersionUID = -4351113632690384920L;
	private String message;
	
	public AccountHandlingException(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
