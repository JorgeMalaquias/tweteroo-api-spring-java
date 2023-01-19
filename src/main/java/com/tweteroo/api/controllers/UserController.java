package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<TweterooUser> listAll(){
        return repository.findAll();
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserDTO reqBody){
        repository.save(new TweterooUser(reqBody));
    }
}
