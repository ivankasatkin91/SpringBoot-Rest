package com.ivankasatkin.spring_boot.rest.service;

import com.ivankasatkin.spring_boot.rest.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ivankasatkin.spring_boot.rest.model.Role;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
