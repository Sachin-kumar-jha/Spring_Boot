package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


import com.spring.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByNameIn(List<String> name);

}
