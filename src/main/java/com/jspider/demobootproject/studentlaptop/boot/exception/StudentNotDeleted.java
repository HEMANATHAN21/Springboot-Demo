package com.jspider.demobootproject.studentlaptop.boot.exception;

public class StudentNotDeleted extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotDeleted(String message) {
		super();
		this.message = message;
	}
	
	
}
