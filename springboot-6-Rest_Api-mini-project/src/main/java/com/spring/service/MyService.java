package com.spring.service;




import java.util.List;
import java.util.Optional;

import com.spring.dto.EmployeeDto;
import com.spring.dto.EmployeeRequestParam;
import com.spring.model.Employee;

public interface MyService {

	Employee employeeService(EmployeeDto employeeDto);
	List<Employee> readEmployee();
	Optional<Employee> readById(int id);
	List<Employee> readdByFields(EmployeeRequestParam empl);
	

}
