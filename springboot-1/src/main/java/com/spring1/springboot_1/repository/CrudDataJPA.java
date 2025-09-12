package com.spring1.springboot_1.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring1.springboot_1.entity.Employee;

public interface CrudDataJPA extends CrudRepository<Employee,Integer>{

}
