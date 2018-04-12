package com.udemy.springboot.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot.restapi.beans.HelloWorldBean;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String sayHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello/{name}")
	public String sayHelloWorldPath(@PathVariable String name) {
		return "Hello World to "+name;
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean sayHelloWorldBean() {
		return new HelloWorldBean("Dhiren");
	}
}
