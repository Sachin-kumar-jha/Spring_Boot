package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Messages {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(max = 20 ,min = 5,message = "Please check size")
	private String name;
	
	@Email(message = "please provide valid email")
	private String email;
	@Size(max = 1000 ,min = 10 ,message = "please provide valid size message")
	private String message;
}
