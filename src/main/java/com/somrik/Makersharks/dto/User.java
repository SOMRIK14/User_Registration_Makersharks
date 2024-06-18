package com.somrik.Makersharks.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3,max = 25,message = "* Please enter between 3 to 25 letters")
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]{5,10}$", message = "Name can only contain letters")
	private String name;
	
	@Size(min = 5,max = 10,message = "* Please enter between 5 to 10 characters")
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]{5,10}$", message = "* Enter combination of chracters")
	String username;
	
	@Email(message = "* Enter valid email")
	@NotNull(message = "* This is required field")
	private String email;
	
	@DecimalMax(value = "9999999999", message = "* Enter proper Mobile Number")
	@DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
	private long mob;
	
	@NotEmpty(message = "* Enter Password")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$", message = "* Password should contain minimum 8 character, inlcude one upper case, lowercase , number and special character")
	private String password;

	
}
