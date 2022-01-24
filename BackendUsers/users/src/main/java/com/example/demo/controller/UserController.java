package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;
    
    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }
}
