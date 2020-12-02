package com.example.demo.Excpetion;

public class NotFoundUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotFoundUserException() {
		super();
	}
	
	public NotFoundUserException(String message) {
		super(message);
	}
	
	

}
