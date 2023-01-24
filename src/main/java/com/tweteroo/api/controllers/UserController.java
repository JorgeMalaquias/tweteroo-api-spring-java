package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.UserRepository;
import com.tweteroo.api.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<TweterooUser> listAll(){
        return service.listAll();
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserDTO reqBody){
        service.signUp(reqBody);
    }
}
