package com.jspider.demobootproject.studentlaptop.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.demobootproject.studentlaptop.boot.dao.LaptopDao;
import com.jspider.demobootproject.studentlaptop.boot.dao.StudentDao;
import com.jspider.demobootproject.studentlaptop.boot.dto.StudentDto;
import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;
import com.jspider.demobootproject.studentlaptop.boot.entity.Student;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNotFound;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentEmptyList;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentNotDeleted;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentNotFound;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentNotSaved;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentNotUpdated;
import com.jspider.demobootproject.studentlaptop.boot.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	StudentDao studentdao;
	@Autowired
	LaptopDao laptopdao;
	public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(Student student)
	{
		ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
		Student s = studentdao.saveStudent(student);
		if(s != null)
		{
			StudentDto dto = new StudentDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(s, dto);
			structure.setMessage("Student Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.CREATED);
		}
		throw new StudentNotSaved("Student Not Saved");
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> findStudent(int studentId)
	{
		ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
		Student s = studentdao.findStudent(studentId);
		if(s != null)
		{
			StudentDto dto = new StudentDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(s, dto);
			structure.setMessage("Student Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.FOUND);
		}
		throw new StudentNotFound("Student Not Found In Given Student Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> deleteStudent(int studentId)
	{
		ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
		Student s = studentdao.findStudent(studentId);
		if(s != null)
		{
			Student student = studentdao.deleteStudent(studentId);
			if(student != null)
			{
				StudentDto dto = new StudentDto();
				ModelMapper mapper = new ModelMapper();
				mapper.map(student, dto);
				structure.setMessage("Student Deleted");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
			}
			throw new StudentNotDeleted("Student Not Deleted In Given Student Id "+studentId);
		}
		throw new StudentNotFound("Student Not Found In Given Student Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> updateStudent(Student student, int studentId)
	{
		Student  s = studentdao.findStudent(studentId);
		if(s != null)
		{
			ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
			Student  update = studentdao.updateStudent(student,studentId);
			if(update != null)
			{
				StudentDto dto = new StudentDto();
				ModelMapper mapper = new ModelMapper();
				mapper.map(update, dto);
				structure.setMessage("Student Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
			}
			throw new StudentNotUpdated("Student Not Updated In Given Student Id "+studentId);
		}
		throw new StudentNotFound("Student Not Found In Given Student Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> assignLaptopToStudent(int studentId,int laptopId)
	{
		Laptop l = laptopdao.findLaptop(laptopId);
		Student s = studentdao.findStudent(studentId);
		if(s != null)
		{
			if(l != null)
			{
				s.setStudentLaptop(l);
				Student updatedStudent = studentdao.updateStudent(s, studentId);
				if(updatedStudent != null)
				{
					StudentDto dto = new StudentDto();
					ModelMapper mapper = new ModelMapper();
					mapper.map(updatedStudent, dto);
					ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
					structure.setMessage("Laptop Assigned for Student");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dto);
					return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
				}
				throw new StudentNotUpdated("Student Not Updated In Given Studen Id "+studentId);
			}
			throw new LaptopNotFound("Laptop Not Found In Given Laptop Id "+laptopId);
		}
		throw new StudentNotFound("Student Not Found In Given Student Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<StudentDto>> removeLaptopFromStudent(int studentId)
	{
		Student s = studentdao.findStudent(studentId);
		if(s != null)
		{
			s.setStudentLaptop(null);
			Student updatedStudent = studentdao.updateStudent(s, studentId);
			if(updatedStudent != null)
			{
				StudentDto dto = new StudentDto();
				ModelMapper mapper = new ModelMapper();
				ResponseStructure<StudentDto> structure = new ResponseStructure<StudentDto>();
				structure.setMessage("Laptop removed from Student");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StudentDto>>(structure,HttpStatus.OK);
			}
			throw new StudentNotUpdated("Student Not Updated In Given Student Id "+studentId);
		}
		throw new StudentNotFound("Student Not Found In Given Student Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<List<StudentDto>>> findAllStudent()
	{
		List<Student> listOfStudent = studentdao.findAllStudent();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudent) 
		{
			StudentDto dto = new StudentDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(student, dto);
			listOfStudentDto.add(dto);
		}
		if(!listOfStudent.isEmpty())
		{
			ResponseStructure<List<StudentDto>> structure = new ResponseStructure<List<StudentDto>>();
			structure.setMessage("Find All Student");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listOfStudentDto);
			return new ResponseEntity<ResponseStructure<List<StudentDto>>>(structure,HttpStatus.FOUND);
		}
		throw new StudentEmptyList("Student List Is Empty");
	}
	
}
