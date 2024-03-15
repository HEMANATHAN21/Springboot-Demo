package com.jspider.demobootproject.studentlaptop.boot.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Component
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@NotNull(message = "student name cannot be null")
	@NotBlank(message = "student name cannot be blank")
	private String studentName;
	@NotNull(message = "student email cannot be null")
	@NotBlank(message = "student email cnnot be blank")
	@Email(message = "Invalid email format")
    @Pattern(regexp=".+@.+\\..+", message="Email address must contain @ symbol")
	private String studentEmail;
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="Password must be 8 digit")
	private String studentPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Laptop studentLaptop;
}
