package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.dto.EmployeeDto;

import com.spring.dto.EmployeeRequest;
import com.spring.dto.UserDto;
import com.spring.model.Employee;
import com.spring.model.User;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.UserRepository;
import com.spring.service.MyService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor //If we don't want to use Autowired for registration of bean
public class MyController {

    private final EmployeeRepository employeeRepository;

    private final UserRepository userRepository;
    
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
	
	@GetMapping("/employee")
	public ResponseEntity<?> readByFields(@RequestParam List<String>ids){
		try {
			 List<EmployeeRequest> list=service.readdByFields(ids);
			 return  ResponseEntity.ok(list);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
           
	}
	
//	@GetMapping(value = "employee",params = "!name")
//	public ResponseEntity<?> readAll() {
//		List<Employee> employee = service.readEmployee();
//		return ResponseEntity.ok(employee);
//	}
	
	
	@GetMapping("employee/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		 Optional<Employee> employee = service.readById(id);
		 if(employee.isPresent()) {
			 return ResponseEntity.ok(employee);
		 }else {
			 return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
		 }
		
	}
	
	@PatchMapping("employee/{id}")
	@Transactional
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody Map<String, String> payload) {
        // Extract the name from the payload map
		try {
			 String name = payload.get("name");

		        if (name == null || name.trim().isEmpty()) {
		            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be null or empty");
		        }

		        Optional<Employee> optionalEmployee = service.readById(id);

		        return optionalEmployee.map(employee -> {
		            employee.setName(name.trim());
		            Employee updatedEmployee = employeeRepository.save(employee);
		            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with ID: " + id));
		} catch (Exception e) {
		return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
		}
	
       
    }
	
	@PostMapping("user")
	public ResponseEntity<?> userCreate(@RequestBody UserDto userDto) {
	try {
	        User user =User.builder()
	        		.username(userDto.getUsername())
	        		.email(userDto.getEmail())
	        		.build();
	      User savedUser = userRepository.save(user);
	      
	      if(savedUser!=null) {
	    	  return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	      }else {
	    	  return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	      }
	        		
	        
	} catch (Exception e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	}
	
	
}

	
	

