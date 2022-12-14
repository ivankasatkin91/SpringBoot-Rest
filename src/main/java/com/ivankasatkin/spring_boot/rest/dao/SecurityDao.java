package com.ivankasatkin.spring_boot.rest.dao;

import com.ivankasatkin.spring_boot.rest.model.User;

public interface SecurityDao {

    User getUserByUsername(String username);
}
