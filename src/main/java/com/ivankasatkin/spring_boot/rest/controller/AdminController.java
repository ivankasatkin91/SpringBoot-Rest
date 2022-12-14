package com.ivankasatkin.spring_boot.rest.controller;

import com.ivankasatkin.spring_boot.rest.model.Role;
import com.ivankasatkin.spring_boot.rest.model.User;
import com.ivankasatkin.spring_boot.rest.service.SecurityService;
import com.ivankasatkin.spring_boot.rest.service.UserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivankasatkin.spring_boot.rest.service.RoleService;

import java.security.Principal;
import java.util.Set;

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
//
//    @PostMapping("/new_save")
//    public String saveUser(@ModelAttribute("new_user") User user) {
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@PathVariable("id") int id,
//                             @RequestParam("name") String name,
//                             @RequestParam("surname") String surname,
//                             @RequestParam("login") String login,
//                             @RequestParam("pass") String password,
//                             @RequestParam("rls") Set<Role> roles) {
//
//        userService.updateUser(id, new User(name, surname, login, password, roles));
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
}
