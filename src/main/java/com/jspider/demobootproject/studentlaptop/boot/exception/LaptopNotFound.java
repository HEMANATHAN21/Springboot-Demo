package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopNotFound extends RuntimeException
{
	String message;
	
	public String getMessage() {
		return message;
	}

	public LaptopNotFound(String message) {
		super();
		this.message = message;
	}
	
}
