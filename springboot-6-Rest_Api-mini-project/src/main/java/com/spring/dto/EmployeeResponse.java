package com.spring.dto;

import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
	private int id;
	private String name;
	private int salary;
	private LocalDate date;
	private String message;
}
