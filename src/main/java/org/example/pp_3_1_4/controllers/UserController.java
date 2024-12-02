package org.example.pp_3_1_4.controllers;

import org.example.pp_3_1_4.model.User;
import org.example.pp_3_1_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserPage(Principal principal, Model model) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("currentUser", user);
        return "user-page";
    }
}
