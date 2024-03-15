package com.jspider.demobootproject.studentlaptop.boot.util;

import lombok.Data;

@Data
public class ResponseStructure<T> 
{
	private String message;
	private int status;
	private T data;
}
