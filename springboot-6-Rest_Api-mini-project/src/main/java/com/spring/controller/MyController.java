package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmployeeDto;

import com.spring.dto.EmployeeRequest;
import com.spring.model.Employee;
import com.spring.service.MyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor //If we don't want to use Autowired for registration of bean
public class MyController {

	private final MyService service;
	
	@PostMapping("/employee")
	public ResponseEntity<?> insert(@Valid @RequestBody EmployeeDto employeeDto,BindingResult bres) {
		
		if(bres.hasErrors()) {
			List<String>list=new ArrayList<>();
			bres.getAllErrors().forEach(error->list.add(error.getDefaultMessage()));
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}else {
			//got to Service
			Employee emp = service.employeeService(employeeDto);
			Map<Object,Object>map=new HashMap<>();
//			EmployeeResponse employeeResponse= EmployeeResponse.builder()
//					 .id(emp.getId())
//					 .name(emp.getName())
//					 .salary(emp.getSalary())
//					 .date(emp.getDate())
//					 .message("Employee saved Succesfully")
//					 .build();
			map.put("message","employee created successfully");
			map.put("data", emp);
			
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
			
	}
	
	
	@GetMapping(value = "employee",params = "!name")
	public ResponseEntity<?> readAll() {
		List<Employee> employee = service.readEmployee();
		return ResponseEntity.ok(employee);
	}
	
	
	@GetMapping("employee/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		 Optional<Employee> employee = service.readById(id);
		 if(employee.isPresent()) {
			 return ResponseEntity.ok(employee);
		 }else {
			 return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
		 }
		
	}
	
	
	@GetMapping("employee")
	public List<EmployeeRequest> readByFields(@RequestParam List<String>name){
              return service.readdByFields(name);      
	}
}
