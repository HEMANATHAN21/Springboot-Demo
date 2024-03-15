package com.jspider.demobootproject.studentlaptop.boot.dto;

import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto 
{
	private int studentId;
	private String studentName;
	private String studentEmail;
	private Laptop studentLaptop;
}
