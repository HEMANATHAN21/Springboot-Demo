package com.jspider.demobootproject.studentlaptop.boot.exception;

public class StudentNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotFound(String message) {
		super();
		this.message = message;
	}
	
	
	

}
