package com.spring2.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring2.entity.Employee;

public interface MyJpaRepository extends JpaRepository<Employee,Integer> {

	List<Employee> findByNameStartsWith(String string);

}
