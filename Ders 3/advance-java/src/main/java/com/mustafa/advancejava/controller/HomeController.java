package com.mustafa.advancejava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home-api") // localhost:8080/home/message....
public class HomeController {

    // Okuyorsak, GET metodu oluşturur, Yazıyorsak POST metodu oluşturur, Silme için DELETE, Günceleme işlemleri için ise PUT

    @GetMapping(path = "/message")
    public String helloMethod() {

        return "Hello World !";
    }
}
