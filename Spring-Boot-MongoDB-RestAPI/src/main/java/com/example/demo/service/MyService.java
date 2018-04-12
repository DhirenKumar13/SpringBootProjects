package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeeDomain;
import com.example.demo.domain.StudentDomain;
import com.example.demo.repository.MyMongoRepository;

@Service
public class MyService implements Services{
	
	@Autowired
	MyMongoRepository repository;
	
	@Override
	public void insertDocumentEmployee(EmployeeDomain domain) {
		repository.save(domain);		
	}

	@Override
	public String getDocumentIdEmployee(EmployeeDomain domain) {
		EmployeeDomain dst = (EmployeeDomain) repository.findByName(domain.getName());
		return dst.getName();
	}

	@Override
	public void insertDocumentStudent(StudentDomain domain) {
		repository.save(domain);		
	}

	@Override
	public String getDocumentIdStudent(StudentDomain domain) {
		StudentDomain dst = 
				(StudentDomain) repository.findByName(domain.getName());
		return dst.getName();
	}
}
