package com.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;
import com.spring.repo.Crud;

import jakarta.transaction.Transactional;


@Service
public class MyService {
	
@Autowired
private Crud crd;

@Autowired
private ModelMapper mapper;

/*
 * public String insertData(EmployeeDTO emp) {
 * 
 * Employee entity= mapper.map(emp,Employee.class);
 * entity.setUcode(emp.getId()+100); crd.save(entity); return
 * "insert successfully"; }
 */
private String result;

//Here Transcational bydefault not rollbacking in checked exception so here we should explicitly call to rollback
@Transactional(rollbackOn = Exception.class)
public String insertData(EmployeeDTO emp,MultipartFile multipart) throws Exception {
	String originalFilename = multipart.getOriginalFilename();
	emp.setMyfile(originalFilename);
	Employee entity= mapper.map(emp,Employee.class);
    entity.setUcode(emp.getId()+100);
    crd.save(entity);
    
    try {
		byte[] bytes = multipart.getBytes();
		String path="C:\\Users\\Sachin Jha\\Desktop\\Spring-boot\\springboot-4\\src\\main\\webapp\\myfiles\\"+originalFilename;
		@SuppressWarnings("resource")
		FileOutputStream fos= new FileOutputStream(path);
		fos.write(bytes);
		
		result="Insert Successfully";
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		result="failed";
		e.printStackTrace();
		throw e;
	}
    
    
	return result;
	}
	
	

public List<Employee> readData(){
	return crd.findAll();
}

public String deleteData(int id) {
	crd.deleteById(id);
	return "delete Successfully";
}
}
