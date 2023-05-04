package org.zerock.myapp.service;


public interface SampleService {
	
	//매개변수 String은 int로 형변환됨 Integer로 인해서
	public abstract Integer plus(String number1, String number2) throws Exception;
} //end interface
