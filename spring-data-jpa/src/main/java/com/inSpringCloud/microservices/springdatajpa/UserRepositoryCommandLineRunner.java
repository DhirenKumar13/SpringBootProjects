package com.inSpringCloud.microservices.springdatajpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.inSpringCloud.microservices.springdatajpa.entity.UserEntity;
import com.inSpringCloud.microservices.springdatajpa.repository.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository service;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserEntity user1 = new UserEntity("Swati", "Admin_User");
		UserEntity user2 = new UserEntity("Shreeja", "System_User");
		service.save(user1);
		service.save(user2);
		
		List<UserEntity> findAll = service.findAll();
		findAll.forEach(user -> {
			LOGGER.info("User Retrieved " + user);
		});
	}

}
