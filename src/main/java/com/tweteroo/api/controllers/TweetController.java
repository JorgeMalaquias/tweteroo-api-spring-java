package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/")
public class TweetController {

    @Autowired
    private TweetRepository repository;

    @Autowired UserRepository userRepository;

    @GetMapping("/tweets/{userName}")
    public List<Tweet> listAllByUserName(@PathVariable String userName){
        return repository.findAll();
    }

    @PostMapping("/tweets")
    public void createTwet(@RequestBody TweetDTO reqBody){
        TweterooUser user = userRepository.findByUserName(reqBody.userName()).get(0);
        repository.save(new Tweet(reqBody,user.getAvatar()));
    }
}