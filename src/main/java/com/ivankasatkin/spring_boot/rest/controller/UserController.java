package com.ivankasatkin.spring_boot.rest.controller;

import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/user")
    public String showUserPage(Principal principal, Model model) {
        User user = securityService.getUserByUsername(principal.getName());
        model.addAttribute("current_user", user);
        return "user_page";
    }
}
