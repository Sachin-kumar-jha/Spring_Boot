package com.spring1.springboot_1;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring1.springboot_1.entity.Employee;
import com.spring1.springboot_1.repository.Crud;
import com.spring1.springboot_1.repository.CrudDataJPA;

@SpringBootApplication
public class Boot1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(Boot1Application.class, args);
		 Employee emp = new Employee(11,"Mohan");
		 
//		Crud crd=ac.getBean(Crud.class);
//		
//		 crd.save(emp);
		
	CrudDataJPA bean = ac.getBean(CrudDataJPA.class);
	bean.save(emp);
	Optional<Employee> byId = bean.findById(10);
	System.out.println(byId.toString());
		
	}

}
