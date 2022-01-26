package com.core.exceptions;

public class AccountHandlingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AccountHandlingException(String msg) {
		super(msg);
		//System.out.println("Exception thrown: " + msg);
	}
}
