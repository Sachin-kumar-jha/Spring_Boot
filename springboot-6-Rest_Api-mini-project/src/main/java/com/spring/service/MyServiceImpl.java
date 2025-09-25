package com.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.dto.EmployeeDto;

import com.spring.dto.EmployeeRequest;
import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyService {

	private final EmployeeRepository empRepository;

	
	@Override
	@Transactional
	public Employee employeeService(EmployeeDto employeeDto) {
	Employee emp= Employee.builder()
				.name(employeeDto.getName())
				.salary(employeeDto.getSalary())
				.date(LocalDate.now())
				.build();
		
	return empRepository.save(emp);
	}


	@Override
	public List<Employee> readEmployee() {
		return empRepository.findAll();
	}


	@Override
	public Optional<Employee> readById(int id) {
		Optional<Employee> emp = empRepository.findById(id);
		return emp;
	}


	public List<EmployeeRequest> readdByFields(List<String> names) {
	    return empRepository.findByNameIn(names).stream()
	            .map(emp -> EmployeeRequest.builder()
	                    .name(emp.getName())
	                    .salary(emp.getSalary() > 10000) // ✅ compiles now
	                    .build()
	            )
	            .toList();
	}

}
