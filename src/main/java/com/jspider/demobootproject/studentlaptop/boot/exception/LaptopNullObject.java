package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopNullObject extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopNullObject(String message) {
		
		this.message = message;
	}

	
	

}
