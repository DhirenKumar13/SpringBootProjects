package com.inSpringCloud.microservices.springdatajpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inSpringCloud.microservices.springdatajpa.entity.UserEntity;

@Repository
@Transactional
public class UserEntityDaoService {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Long saveUser(UserEntity user) {
		manager.persist(user);
		return user.getUserID();
	}
	
}
