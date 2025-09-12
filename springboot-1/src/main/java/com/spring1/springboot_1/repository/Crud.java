package com.spring1.springboot_1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring1.springboot_1.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class Crud{
	@Autowired
     private EntityManager entitymanager; //HBN-Impl

	@Transactional
  public void save(Employee emp) {
	  entitymanager.persist(emp);  //HBNImpl method
  }
     
}
