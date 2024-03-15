package com.jspider.demobootproject.studentlaptop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.demobootproject.studentlaptop.boot.dao.LaptopDao;
import com.jspider.demobootproject.studentlaptop.boot.dao.StudentDao;
import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;
import com.jspider.demobootproject.studentlaptop.boot.entity.Student;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopEmptyList;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNotDeleted;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNotFound;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNotSaved;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNotUpdated;
import com.jspider.demobootproject.studentlaptop.boot.exception.LaptopNullObject;
import com.jspider.demobootproject.studentlaptop.boot.exception.StudentNotFound;
import com.jspider.demobootproject.studentlaptop.boot.repo.LaptopRepo;
import com.jspider.demobootproject.studentlaptop.boot.util.ResponseStructure;

@Service
public class LaptopService 
{
	@Autowired
	LaptopDao laptopdao;
	@Autowired
	StudentDao studentdao;
	
	public ResponseEntity<ResponseStructure<Laptop>> saveLaptop(Laptop laptop)
	{
		ResponseStructure<Laptop> structure = new ResponseStructure<Laptop>();
		Laptop l = laptopdao.saveLaptop(laptop);
		if(l != null)
		{
			structure.setMessage("Laptop Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.CREATED);
		}
		throw new LaptopNotSaved("Laptop Not Saved");
	}
	
	public ResponseEntity<ResponseStructure<Laptop>> findLaptop(int laptopId)
	{
		ResponseStructure<Laptop> structure = new ResponseStructure<Laptop>();
		Laptop l = laptopdao.findLaptop(laptopId);
		if(l != null)
		{
			structure.setMessage("Laptop Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.FOUND);
		}
		throw new LaptopNotFound("Laptop Not Found In Given Id "+laptopId);
		
	}
	
	public ResponseEntity<ResponseStructure<Laptop>> deleteLaptop(int laptopId)
	{
		ResponseStructure<Laptop> structure = new ResponseStructure<Laptop>();
		Laptop l = laptopdao.findLaptop(laptopId);
		if(l != null)
		{
			Laptop laptop = laptopdao.deleteLaptop(laptopId);
			if(laptop != null)
			{
				structure.setMessage("Laptop Deleted");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(laptop);
				return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.OK);
			}
			throw new LaptopNotDeleted("Laptop Not Deleted In Given Id "+laptopId);
		}
		throw new LaptopNotFound("Laptop Not Found In Given Id "+laptopId);
	}
	
	public ResponseEntity<ResponseStructure<Laptop>> updateLaptop(Laptop laptop, int laptopId)
	{
		ResponseStructure<Laptop> structure = new ResponseStructure<Laptop>();
		Laptop l = laptopdao.findLaptop(laptopId);
		if(l != null)
		{
			Laptop update = laptopdao.updateLaptop(laptop,laptopId);
			if(update != null)
			{
				structure.setMessage("Laptop Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(update);
				return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.OK);
			}
			throw new LaptopNotUpdated("Laptop Not Updated In Given Id "+laptopId);
		}
		throw new LaptopNotFound("Laptop Not Found In Given Id "+laptopId);
		
	}
	
	public ResponseEntity<ResponseStructure<Laptop>> deleteLaptopUsingStudentId(int studentId)
	{
		Student s = studentdao.findStudent(studentId);
		if(s != null)
		{
			if(s.getStudentLaptop() != null)
			{
				int laptopId = s.getStudentLaptop().getLaptopId();
				s.setStudentLaptop(null);
				studentdao.updateStudent(s, studentId);
				Laptop laptop = laptopdao.deleteLaptop(laptopId);
				if(laptop != null)
				{
					ResponseStructure<Laptop> structure = new ResponseStructure<Laptop>();
					structure.setMessage("Laptop Deleted");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(laptop);
					return new ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.OK);
				}
				throw new LaptopNotDeleted("Laptop Not Deleted In Given Id "+laptopId);
			}
			throw new LaptopNullObject("Laptop Object Is Null In Givent Student Id "+studentId);
		}
		throw new StudentNotFound("Student Not Found In Given Id "+studentId);
	}
	
	public ResponseEntity<ResponseStructure<List<Laptop>>> findAllLaptop()
	{
		List<Laptop> listOfLaptop = laptopdao.findAllLaptop();
		if(!listOfLaptop.isEmpty())
		{
			ResponseStructure<List<Laptop>> structure = new ResponseStructure<List<Laptop>>();
			structure.setMessage("Find All Laptop");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(listOfLaptop);
			return new ResponseEntity<ResponseStructure<List<Laptop>>>(structure,HttpStatus.FOUND);
		}
		throw new LaptopEmptyList("List Is Empty");
	}
}
