package com.ivankasatkin.spring_boot.rest.service;

import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
