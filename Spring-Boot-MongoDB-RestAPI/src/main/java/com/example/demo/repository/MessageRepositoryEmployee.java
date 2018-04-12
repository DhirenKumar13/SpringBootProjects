package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.EmployeeDomainQueue;

public interface MessageRepositoryEmployee extends MongoRepository<EmployeeDomainQueue, String>{

}
