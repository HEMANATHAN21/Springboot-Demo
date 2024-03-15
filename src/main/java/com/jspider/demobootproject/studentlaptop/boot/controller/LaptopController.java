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

import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;
import com.jspider.demobootproject.studentlaptop.boot.service.LaptopService;
import com.jspider.demobootproject.studentlaptop.boot.util.ResponseStructure;

import jakarta.validation.Valid;
@RestController
@RequestMapping("laptop")
public class LaptopController 
{
	@Autowired
	LaptopService laptopService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Laptop>> saveLaptop(@Valid @RequestBody Laptop laptop,BindingResult result)
	{
		return laptopService.saveLaptop(laptop);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Laptop>> findLaptop(@RequestParam int laptopId)
	{
		return laptopService.findLaptop(laptopId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Laptop>> deleteLaptop(@RequestParam int laptopId)
	{
		return laptopService.deleteLaptop(laptopId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Laptop>> updateLaptop(@RequestBody Laptop laptop, @RequestParam int laptopId)
	{
		return laptopService.updateLaptop(laptop, laptopId);
	}
	@DeleteMapping("lapdel")
	public ResponseEntity<ResponseStructure<Laptop>> deleteLaptopUsingStudentId(@RequestParam int studentId)
	{
		return laptopService.deleteLaptopUsingStudentId(studentId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<Laptop>>> findAllLaptop()
	{
		return laptopService.findAllLaptop();
	}

	
	
}
