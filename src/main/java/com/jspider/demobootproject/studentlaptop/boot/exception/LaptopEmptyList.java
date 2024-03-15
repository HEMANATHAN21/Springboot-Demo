package com.jspider.demobootproject.studentlaptop.boot.exception;

public class LaptopEmptyList extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopEmptyList(String message) {
		super();
		this.message = message;
	}

	
	
}
