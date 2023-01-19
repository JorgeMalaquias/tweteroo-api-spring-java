package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @PostMapping
    public void signUp(@RequestBody UserDTO reqBody){
        repository.save(new TweterooUser(reqBody));
    }
}
