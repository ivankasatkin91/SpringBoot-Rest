package com.ivankasatkin.spring_boot.rest.controller;

import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.service.SecurityService;
import com.ivankasatkin.spring_boot.rest.service.UserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivankasatkin.spring_boot.rest.service.RoleService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("")
    public String showUserList(Model model, Principal principal) {
        User user = securityService.getUserByUsername(principal.getName());
        model.addAttribute("new_user", new User());
        model.addAttribute("current_user", user);
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("all_roles", roleService.listRoles());
        return "admin_page";
    }
}
