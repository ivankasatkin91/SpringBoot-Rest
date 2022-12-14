package com.ivankasatkin.spring_boot.rest.dao;

import com.ivankasatkin.spring_boot.rest.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
}
