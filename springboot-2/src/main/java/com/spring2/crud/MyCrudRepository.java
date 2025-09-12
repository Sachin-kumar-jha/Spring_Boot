package com.spring2.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring2.entity.Employee;

public interface MyCrudRepository extends CrudRepository<Employee,Integer> {
//
//	@Override
//	Iterable<Employee> findAll();
//	
//	@Query(value = "select * from employee where name like 'g%'" ,nativeQuery=true)
//	List<Employee> readMydata();  //CUSTOM METHOD
//	
//	@Query(value = " from Employee where name like 'g%'")
//	List<Employee> readMydataHQL(); //CUSTOM METHOD
//	
	//Spring understand that query => Select * from employee where name=:name"
	List<Employee> findByName(String name);
	List<Employee> findByNameStartsWith(String prefix);
	
}
