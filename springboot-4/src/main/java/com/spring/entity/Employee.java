package com.spring.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Employee {
 
	@Id
	private int id;
	private String name;
	private LocalDate date;
	private int ucode; //application generated
	private String myfile;
}
