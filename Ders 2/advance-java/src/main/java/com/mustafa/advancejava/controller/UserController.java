package com.mustafa.advancejava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserController {

    @GetMapping("/")
    public String userInfo() {

        return "Welcome Mustafa Karakaş";
    }
}
