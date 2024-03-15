package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopNotDeleted extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopNotDeleted(String message) {
		super();
		this.message = message;
	}
	
	
	

}
