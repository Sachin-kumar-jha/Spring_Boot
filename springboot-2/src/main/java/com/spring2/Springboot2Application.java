package com.spring2;

import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;

import com.spring2.crud.MyCrudRepository;
import com.spring2.crud.MyJpaRepository;
import com.spring2.entity.Employee;

@SpringBootApplication
public class Springboot2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(Springboot2Application.class, args);
		
//		Employee emp = new Employee(12,"gagan");
		
//		MyCrudRepository crd = ac.getBean(MyCrudRepository.class);
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
		
		MyJpaRepository crd = ac.getBean(MyJpaRepository.class);
//		List<Employee> byNameStartsWith = crd.findByNameStartsWith("m");
//		System.out.println(byNameStartsWith);
		
//		List<Employee> all = crd.findAll();
//		
//		List<Employee> all2 = crd.findAll(Sort.by("id").ascending());
//		
//		all2.forEach(n->System.out.println(n));
		
		Page<Employee> all = crd.findAll(PageRequest.of(0, 4));
		
		Streamable<Employee> filter = all.filter((emp)-> emp.getId()%2 == 0);
		
      Streamable<String> map = filter.map(n->n.getName());
		System.out.println(map.toList());
		//filter.forEach(n->System.out.println(n));
		
		
		
	}

}
