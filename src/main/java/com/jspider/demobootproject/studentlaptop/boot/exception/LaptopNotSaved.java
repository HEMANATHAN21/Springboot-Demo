package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopNotSaved extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopNotSaved(String message) {
		super();
		this.message = message;
	}

	
	

}
