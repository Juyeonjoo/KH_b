package org.zerock.myapp.exception;


public class ControllerException extends Exception {
	
	private static final long serialVersionUID =1L;

	public ControllerException(String message) {
		super(message);
	}//ServiceException
	
	public ControllerException(Exception originalException) {
		super(originalException);		
	}//ServiceException
	
}//end class
