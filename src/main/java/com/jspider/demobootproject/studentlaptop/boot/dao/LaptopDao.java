package com.jspider.demobootproject.studentlaptop.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.demobootproject.studentlaptop.boot.entity.Laptop;
import com.jspider.demobootproject.studentlaptop.boot.repo.LaptopRepo;
@Repository
public class LaptopDao 
{
	@Autowired
	LaptopRepo laptopRepo;
	
	public Laptop saveLaptop(Laptop laptop)
	{
		return laptopRepo.save(laptop);
	}
	
	public Laptop findLaptop(int laptopId)
	{
		Optional<Laptop> opLaptop = laptopRepo.findById(laptopId);
		if(opLaptop.isPresent())
			return opLaptop.get();
		return null;
	}
	
	public Laptop deleteLaptop(int laptopId)
	{
		Laptop laptop = findLaptop(laptopId);
		laptopRepo.delete(laptop);
		return laptop;
	}
	
	public Laptop updateLaptop(Laptop laptop, int laptopId)
	{
		Laptop exLaptop = findLaptop(laptopId);
		if(exLaptop != null)
		{
			laptop.setLaptopId(laptopId);
			return laptopRepo.save(laptop);
		}
		return null;
	}
	
	public List<Laptop> findAllLaptop()
	{
		return laptopRepo.findAll();

	}
	
}
