package com.udemy.springboot.basics.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootStarterApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootStarterApplication.class, args);
		for(String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);	
		}
	}
}
