package org.doInSpringBoot.restservices.restfulwebservices.repository;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.PostByUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostByUsers, Integer> {
}
