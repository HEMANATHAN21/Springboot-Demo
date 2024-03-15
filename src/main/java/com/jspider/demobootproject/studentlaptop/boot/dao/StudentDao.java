package com.jspider.demobootproject.studentlaptop.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;
import com.jspider.demobootproject.studentlaptop.boot.entity.Student;
import com.jspider.demobootproject.studentlaptop.boot.repo.StudentRepo;

@Repository
public class StudentDao 
{
	@Autowired
	StudentRepo studentrepo;
	
	public Student saveStudent(Student student)
	{
		return studentrepo.save(student);
	}
	
	public Student findStudent(int studentId)
	{
		Optional<Student> opStudent = studentrepo.findById(studentId);
		if(opStudent.isPresent())
			return opStudent.get();
		return null;
	}
	
	public Student deleteStudent(int studentId)
	{
		Student student = findStudent(studentId);
		studentrepo.delete(student);
		return student;
	}
	
	public Student updateStudent(Student student, int studentId)
	{
		Student exStudent = findStudent(studentId);
		if(exStudent != null)
		{
			student.setStudentId(studentId);
			return studentrepo.save(student);
		}
		return null;
	}
	
	public List<Student> findAllStudent()
	{
		return studentrepo.findAll();
	}
}
