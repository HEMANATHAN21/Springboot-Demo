package com.jspider.demobootproject.studentlaptop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.demobootproject.studentlaptop.boot.dto.StudentDto;
import com.jspider.demobootproject.studentlaptop.boot.entity.Student;
import com.jspider.demobootproject.studentlaptop.boot.service.StudentService;
import com.jspider.demobootproject.studentlaptop.boot.util.ResponseStructure;

import jakarta.validation.Valid;
@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(@Valid @RequestBody Student student,BindingResult result)
	{
		return studentservice.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<StudentDto>> findStudent(@RequestParam int studentId)
	{
		return studentservice.findStudent(studentId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<StudentDto>> deleteStudent(@RequestParam int studentId)
	{
		return studentservice.deleteStudent(studentId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(@RequestBody Student student, @RequestParam int studentId)
	{
		return studentservice.updateStudent(student, studentId);
	}
	@PutMapping("assign")
	public ResponseEntity<ResponseStructure<StudentDto>> assignLaptopToStudent(@RequestParam int studentId, @RequestParam int laptopId)
	{
		return studentservice.assignLaptopToStudent(studentId, laptopId);
	}
	
	@PutMapping("remlap")
	public ResponseEntity<ResponseStructure<StudentDto>> removeLaptopFromStudent(@RequestParam int studentId)
	{
		return studentservice.removeLaptopFromStudent(studentId);
	}
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findAllStudent()
	{
		return studentservice.findAllStudent();
	}
}
