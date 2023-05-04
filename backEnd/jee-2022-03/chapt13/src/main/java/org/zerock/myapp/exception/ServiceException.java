package org.zerock.myapp.exception;


public class ServiceException extends Exception {
	
	private static final long serialVersionUID =1L;

	public ServiceException(String message) {
		super(message);
	}//ServiceException
	
	public ServiceException(Exception originalException) {
		super(originalException);		
	}//ServiceException
	
}//end class
