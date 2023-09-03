package com.example.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.web.model.Employee;

public interface EmployeeRepo  extends MongoRepository<Employee,Integer> {
    

}
