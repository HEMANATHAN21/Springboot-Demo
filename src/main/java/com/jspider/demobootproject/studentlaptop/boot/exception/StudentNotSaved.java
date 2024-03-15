package com.jspider.demobootproject.studentlaptop.boot.exception;

public class StudentNotSaved extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotSaved(String message) {
		super();
		this.message = message;
	}
	
	
	
}
