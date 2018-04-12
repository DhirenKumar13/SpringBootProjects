package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.StudentDomainQueue;

public interface MessageRepositoryStudent extends MongoRepository<StudentDomainQueue, String>{

}
