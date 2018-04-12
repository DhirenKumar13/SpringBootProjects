package com.udemy.springboot.restapi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.udemy.springboot.restapi.beans.User;

@Component
public class UserDao {
	private static List<User> list = new ArrayList<>();
	private static Integer userCount = 317101;
	static {
		list.add(new User("Dhiren",317097,new Date()));
		list.add(new User("Swati",317098,new Date()));
		list.add(new User("Shruti",317099,new Date()));
		list.add(new User("Shreeja",317100,new Date()));
		list.add(new User("Ankit",317101,new Date()));
	}
	public List<User> getAllUsers(){
		return list;
	}
	public User saveUser(User newUser) {
		if(newUser.getId() == null) {
			newUser.setId(++userCount);
		}
		list.add(newUser);
		return newUser;
	}
	
	public User findOne(Integer id) {
		return list.stream()
				.filter((user) -> user.getId().equals(id))
				.findAny().get();
	}
}
