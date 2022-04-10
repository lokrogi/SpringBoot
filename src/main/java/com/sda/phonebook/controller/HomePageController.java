package com.sda.phonebook.controller;

import com.sda.phonebook.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @GetMapping("/home")
    public String someData() {
        if(user != null) {
            return "index";
        } else {
            return "redirect: ";
        }
    }
}
