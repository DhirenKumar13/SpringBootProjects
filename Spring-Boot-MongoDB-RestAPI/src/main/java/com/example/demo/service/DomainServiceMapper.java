package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeeDomainQueue;
import com.example.demo.domain.StudentDomainQueue;
import com.example.demo.repository.MessageRepositoryEmployee;
import com.example.demo.repository.MessageRepositoryStudent;

@Service
public class DomainServiceMapper {
	
	@Autowired
	MessageRepositoryEmployee employee;
	
	@Autowired
	MessageRepositoryStudent student;
	
	public void saveEmployee(EmployeeDomainQueue domain) {
		employee.save(domain);
	}
	
	public void saveStudent(StudentDomainQueue domain) {
		student.save(domain);
	}
	
}
