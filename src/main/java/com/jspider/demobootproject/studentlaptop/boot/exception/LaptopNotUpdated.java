package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopNotUpdated extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopNotUpdated(String message) {
		super();
		this.message = message;
	}

	
	

}
