package com.inSpringCloud.microservices.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.inSpringCloud.microservices.springdatajpa.entity.UserEntity;
import com.inSpringCloud.microservices.springdatajpa.service.UserEntityDaoService;

@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserEntityDaoService service;
	
	@Override
	public void run(String... args) throws Exception {
		UserEntity user1 = new UserEntity("Dhiren", "Admin_User");
		UserEntity user2 = new UserEntity("Anushka", "System_User");
		service.saveUser(user1);
		service.saveUser(user2);
	}

}
