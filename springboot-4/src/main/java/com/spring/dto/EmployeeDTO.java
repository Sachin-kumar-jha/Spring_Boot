package com.spring.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class EmployeeDTO {
	
	//For primitive validation
	
	@Min(value=10 , message="ID SHOULD NOT BE LESS THAN 10")
	@Max(value=99 ,message = "ID SHOULD NOT BE GREATER THAN 99")
	private int id;
	
	@Size(min=2,max=30,message="INVALID NAME LENGTH")
	@NotBlank(message="NAME CANNOT BE BLANK")
	@NotEmpty(message="NAME IS REQUIRED")
	//Also we check with regular expression
	@Pattern(regexp = "^[A-Z]+$" ,message="Only alphabet allowed here")
	private String name;
	
	
	@NotNull(message="date can't be null")
	private LocalDate date; //Default null
	
}
