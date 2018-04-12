package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeeDomainQueue;
import com.example.demo.domain.StudentDomainQueue;

@Service
public class MessageServiceProducer {
	
	@Autowired
	private RabbitTemplate template;
	
	public void produceMessage(String exchange,String routingKey,EmployeeDomainQueue all) {
		template.convertAndSend(exchange,routingKey,all);
	}
	
	public void produceMessage(String exchange,String routingKey,StudentDomainQueue all) {
		template.convertAndSend(exchange,routingKey,all);
	}
	
}
