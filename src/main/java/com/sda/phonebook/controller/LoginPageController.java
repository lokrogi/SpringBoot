package com.sda.phonebook.controller;

import com.sda.phonebook.model.User;
import com.sda.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginPageController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String welcomePage() {
        return "welcome";
    }

    @PostMapping("/signup")
    public String signUp(User user) {
        if(userService.createUser(user)) {
            return "index";
        } else {
            return "redirect: ";
        }
    }

    @GetMapping("/login")
    public String logIn(User user) {
        if(userService.login(user)) {
            return "index";
        } else {
            return "redirect: ";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect: ";
    }
}
