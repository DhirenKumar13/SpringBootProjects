package org.doInSpringBoot.restservices.restfulwebservices.repository;

import java.util.Optional;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findById(Integer id);
}
