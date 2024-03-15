package com.jspider.demobootproject.studentlaptop.boot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspider.demobootproject.studentlaptop.boot.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopNotFoundException(LaptopNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Laptop Does Not Exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentNotFoundException(StudentNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Student Does Not Exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopNotUpdatedException(LaptopNotUpdated ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Laptop Not Updated");
		structure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_IMPLEMENTED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentNotUpdatedException(StudentNotUpdated ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Student Not Updated");
		structure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_IMPLEMENTED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopNotSavedException(LaptopNotSaved ex)
	{
		ResponseStructure<String >structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Laptop Not Saved");
		structure.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.EXPECTATION_FAILED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentNotSavedException(StudentNotSaved ex)
	{
		ResponseStructure<String >structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Student Not Saved");
		structure.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.EXPECTATION_FAILED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopNullObjectException(LaptopNullObject ex)
	{
		ResponseStructure<String >structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Laptop Object Is Null");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopNotDeletedException(LaptopNotDeleted ex)
	{
		ResponseStructure<String >structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Laptop Is Not Deleted");
		structure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_IMPLEMENTED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentNotDeletedException(StudentNotDeleted ex)
	{
		ResponseStructure<String >structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Student Is Not Deleted");
		structure.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_IMPLEMENTED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> laptopEmptyListException(LaptopEmptyList ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Empty Laptop List");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> studentEmptyListException(StudentEmptyList ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Empty Student List");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<Object>> handleConstrainViolationException(ConstraintViolationException ex)
	{
		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String, String> hashmap = new HashMap<String, String>();
		for(ConstraintViolation<?> violation : ex.getConstraintViolations())
		{
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessage("add proper data");
		structure.setData(hashmap);
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<Object>>(structure,HttpStatus.BAD_REQUEST);
	}
}
