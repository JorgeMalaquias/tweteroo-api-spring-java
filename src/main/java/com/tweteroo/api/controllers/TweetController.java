package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import com.tweteroo.api.services.TweetService;

@RestController
@RequestMapping("/")
public class TweetController {

    

    @Autowired
    TweetService service;

    @GetMapping("/tweets/{userName}")
    public List<Tweet> listAllByUserName(@PathVariable String userName) {
        return service.listAllByUserName(userName);
    }

    @PostMapping("/tweets")
    public void createTwet(@RequestBody TweetDTO reqBody) {
        service.createTwet(reqBody);
    }

    @GetMapping("/tweets")
    public Page<Tweet> list(@PageableDefault(page = 0, size = 5) Pageable page) {
        return service.list(page);
    }
}