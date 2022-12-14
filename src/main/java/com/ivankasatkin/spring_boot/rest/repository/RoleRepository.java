package com.ivankasatkin.spring_boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ivankasatkin.spring_boot.rest.model.Role;

        // Repository is used for JUnit tests

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
