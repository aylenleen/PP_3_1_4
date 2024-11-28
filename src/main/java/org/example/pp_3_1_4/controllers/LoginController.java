package org.example.pp_3_1_4.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@EnableAutoConfiguration
public class LoginController {

    @GetMapping
    public String showHomePage() {
        return "home";
    }

}
