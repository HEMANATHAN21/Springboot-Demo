package com.jspider.demobootproject.studentlaptop.boot.exception;

public class StudentNotUpdated extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotUpdated(String message) {
		super();
		this.message = message;
	}


}
