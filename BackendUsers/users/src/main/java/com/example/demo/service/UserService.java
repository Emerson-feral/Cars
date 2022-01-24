package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository repository;

    public User saveUser(User user){
        if(user.getName() == null){
            throw new IllegalArgumentException("The user name cannot be empty");
        }

        if(user.getRole() == null){
            throw new IllegalArgumentException("The user role cannot be empty");
        }

        return repository.save(user);
    }


}
