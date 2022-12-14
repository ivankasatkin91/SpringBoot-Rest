package com.ivankasatkin.spring_boot.rest.dao;

import com.ivankasatkin.spring_boot.rest.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> listRoles();
}
