package com.prototype.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @RequestMapping(path = "login")
    public String login() {
        return "Login";
    }
}
