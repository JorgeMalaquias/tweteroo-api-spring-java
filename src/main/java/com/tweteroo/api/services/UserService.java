package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    
    public List<TweterooUser> listAll(){
        return repository.findAll();
    }

    
    public void signUp(UserDTO reqBody){
        repository.save(new TweterooUser(reqBody));
    }
}
