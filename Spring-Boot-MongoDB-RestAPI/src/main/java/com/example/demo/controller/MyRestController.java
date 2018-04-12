package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.EmployeeDomain;
import com.example.demo.domain.EmployeeDomainQueue;
import com.example.demo.domain.StudentDomain;
import com.example.demo.domain.StudentDomainQueue;
import com.example.demo.service.MessageServiceProducer;
import com.example.demo.service.Services;

@RestController
public class MyRestController {
	
	@Autowired
	Services service;
	
	@Value("${rabbitmq.exchange.name}")
	String exchangeName;
	
	@Value("${rabbitmq.routing.students.key.name}")
	String studentKeyName;
	
	@Value("${rabbitmq.routing.employees.key.name}")
	String employeeKeyName;
	
	@Autowired
	MessageServiceProducer producer;
	
	@RequestMapping("/say")
	public String sayHelloByGet() {
		return "Dhiren";
	}
	
	@RequestMapping(value = "/employee",method = RequestMethod.POST )
	public ResponseEntity<?> sayHelloToEmployeeByPost(@RequestBody EmployeeDomain domain) {
		String name = domain.getName();
		Integer age = domain.getAge();
		EmployeeDomain created = new EmployeeDomain(name,age);
		service.insertDocumentEmployee(domain);
		EmployeeDomainQueue queue = new EmployeeDomainQueue(name,age,"SAVED");
		producer.produceMessage(exchangeName, employeeKeyName, queue);
		return ResponseEntity.accepted().body(created);
	}
	
	@RequestMapping(value = "/student",method = RequestMethod.POST )
	public ResponseEntity<?> sayHelloToStudentByPost(@RequestBody StudentDomain domain) {
		String name = domain.getName();
		Integer age = domain.getAge();
		StudentDomain created = new StudentDomain(name,age);
		service.insertDocumentStudent(created);
		StudentDomainQueue queue = new StudentDomainQueue(name,age,"SAVED");
		producer.produceMessage(exchangeName, studentKeyName, queue);
		return ResponseEntity.accepted().body(created);
	}
}
