package com.ivankasatkin.spring_boot.rest.repository;

import com.ivankasatkin.spring_boot.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

        // Repository is used for JUnit tests

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
