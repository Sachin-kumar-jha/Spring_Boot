package com.spring2;

import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.spring2.crud.MyCrudRepository;
import com.spring2.entity.Employee;

@SpringBootApplication
public class Springboot2Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(Springboot2Application.class, args);
		
//		Employee emp = new Employee(12,"gagan");
		
		MyCrudRepository crd = ac.getBean(MyCrudRepository.class);
//		Employee save = crd.save(emp);
//		System.out.println(save);
		
//		Iterable<Employee> all = crd.findAll();
//		
//		all.forEach((val)->System.out.println(val));
//		for(Employee e:all) {
//			System.out.println(e);
//		}
		//crd.readMydata().forEach(emp->System.out.println(emp));
//		crd.readMydataHQL().forEach(emp->System.out.println(emp));
//		
//		Optional<Employee> byId = crd.findById(10);
//		Employee employee = byId.get();
//		System.out.println(employee);
//		List<Employee> byName = crd.findByName("gagan");
//		System.out.println(byName);
		
		List<Employee> byNameStartsWith = crd.findByNameStartsWith("m");
		System.out.println(byNameStartsWith);
	}

}
