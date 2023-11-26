package com.mustafa.advancejava.controller;

import com.mustafa.advancejava.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userInfo() {

        return "Welcome Mustafa Karakaş";
    }

    @PostMapping("/create-user")
    public int createUser(@RequestParam String name, @RequestParam String surname, @RequestParam Integer age) {

        return userService.createUser(name, surname, age);
    }

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return userService.readUsers();
    }

    @GetMapping("/user/{id}")
    public Map<String, Object> getUserById(@PathVariable("id") Integer id) {
        return userService.readUserById(id);
    }

    @PutMapping("/user/{id}")
    public int updateUserById(@PathVariable("id") Integer id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String surname,
                              @RequestParam(required = false) Integer age) {
        return userService.updateUserById(id, name, surname, age);
    }

    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }
}
