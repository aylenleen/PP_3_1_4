package org.example.pp_3_1_4.controllers;

import org.example.pp_3_1_4.model.User;
import org.example.pp_3_1_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableAutoConfiguration
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getCurrentUser(Principal principal) {
        return (User) userService.loadUserByUsername(principal.getName());
    }
}
