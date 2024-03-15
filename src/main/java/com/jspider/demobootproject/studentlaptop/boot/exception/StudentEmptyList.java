package com.jspider.demobootproject.studentlaptop.boot.exception;

public class StudentEmptyList extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public StudentEmptyList(String message) {
		super();
		this.message = message;
	}

}
