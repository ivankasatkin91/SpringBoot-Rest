package com.ivankasatkin.spring_boot.rest.dao;

import com.ivankasatkin.spring_boot.rest.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> listUsers();

}
