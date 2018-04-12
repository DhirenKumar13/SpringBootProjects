package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeeDomain;
import com.example.demo.domain.StudentDomain;

@Service
public interface Services {
	public void insertDocumentEmployee(EmployeeDomain domain);
	public String getDocumentIdEmployee(EmployeeDomain domain);
	public void insertDocumentStudent(StudentDomain domain);
	public String getDocumentIdStudent(StudentDomain domain);
}
