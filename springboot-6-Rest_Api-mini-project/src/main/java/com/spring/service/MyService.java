package com.spring.service;




import java.util.List;
import java.util.Optional;

import com.spring.dto.EmployeeDto;
import com.spring.dto.EmployeeRequest;
import com.spring.model.Employee;

public interface MyService {

	Employee employeeService(EmployeeDto employeeDto);
	List<Employee> readEmployee();
	Optional<Employee> readById(int id);
	List<EmployeeRequest> readdByFields(List<String>name);
	

}
