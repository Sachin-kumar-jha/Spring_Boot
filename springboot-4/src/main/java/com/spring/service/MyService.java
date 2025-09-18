package com.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;
import com.spring.repo.Crud;


@Service
public class MyService {
	
@Autowired
private Crud crd;

@Autowired
private ModelMapper mapper;

public String insertData(EmployeeDTO emp) {
	   
	Employee entity= mapper.map(emp,Employee.class);
    entity.setUcode(emp.getId()+100);
    crd.save(entity);
	return "insert successfully";
	}
	

public List<Employee> readData(){
	return crd.findAll();
}
	
}
