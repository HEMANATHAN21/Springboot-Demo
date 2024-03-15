package com.jspider.demobootproject.studentlaptop.boot.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Component
public class Laptop 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int laptopId;
	@NotNull(message = "laptop name connot be null")
	@NotBlank(message = "laptop name cannot be blank")
	private String laptopName;
	@NotNull(message = "laptop brand connot be null")
	@NotBlank(message = "laptop brand cannot be blank")
	private String laptopBrand;
}
