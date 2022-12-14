package com.ivankasatkin.spring_boot.rest.controller;

import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.service.SecurityService;
import com.ivankasatkin.spring_boot.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest")
public class RestUserController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/user_page")
    public ResponseEntity<User> showCurrentUser(Principal principal) {
        return new ResponseEntity<>(securityService.getUserByUsername(principal.getName()), HttpStatus.OK);
    }
}
