package com.ivankasatkin.spring_boot.rest.app;

import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserTests {

    @Autowired
    private UserRepository repo;

//    @PersistenceContext
//    private EntityManager em;

    @Test
    public void getUserAndRoles() {
        User user = repo.findById(1).get();
        System.out.println(user);
    }

}
