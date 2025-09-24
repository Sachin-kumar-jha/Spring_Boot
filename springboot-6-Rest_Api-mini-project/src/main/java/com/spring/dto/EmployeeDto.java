package com.spring.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDto {
	@Size(min = 4,max = 20 , message = "Name sixe validation failed")
	private String name;
	
	@Min(10000)
	@Max(Integer.MAX_VALUE)
	private int salary;
	
}
