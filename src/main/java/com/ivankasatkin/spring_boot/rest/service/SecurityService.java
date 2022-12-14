package com.ivankasatkin.spring_boot.rest.service;

import com.ivankasatkin.spring_boot.rest.dao.SecurityDao;
import com.ivankasatkin.spring_boot.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private SecurityDao securityDao;

    public User getUserByUsername(String username) {
        return securityDao.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException(String.format("User '%s' not found!", username));
        return user;
    }
}
