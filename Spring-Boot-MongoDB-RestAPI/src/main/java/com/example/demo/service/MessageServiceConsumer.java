package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeeDomainQueue;
import com.example.demo.domain.StudentDomainQueue;

@Service
public class MessageServiceConsumer {
	
	@Autowired
	DomainServiceMapper mapper;
	
	@RabbitListener(queues = "${rabbitmq.student.queue}")
	public void receiveMessageStudent(StudentDomainQueue domain) {
		mapper.saveStudent(domain);
	}
	
	@RabbitListener(queues = "${rabbitmq.employee.queue}")
	public void receiveMessageEmployee(EmployeeDomainQueue domain) {
		mapper.saveEmployee(domain);
	}
}
