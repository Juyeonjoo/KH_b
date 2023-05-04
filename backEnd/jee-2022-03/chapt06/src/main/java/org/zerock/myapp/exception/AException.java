package org.zerock.myapp.exception;

public class AException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AException(String message) {
		super(message);
	}//Constructor#1
	
	public AException(Exception e) {
		super(e);
	}//Constructor#2
	
} // AException
