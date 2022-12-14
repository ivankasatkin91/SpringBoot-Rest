package com.ivankasatkin.spring_boot.rest.service;

import com.ivankasatkin.spring_boot.rest.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> listUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
