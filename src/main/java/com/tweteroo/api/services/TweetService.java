package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.TweterooUser;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;


@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    UserRepository userRepository;

    
    public List<Tweet> listAllByUserName(String userName) {
        return repository.findByUserName(userName);
    }

   
    public void createTwet(TweetDTO reqBody) {
        TweterooUser user = userRepository.findByUserName(reqBody.userName()).get(0);
        repository.save(new Tweet(reqBody, user.getAvatar()));
    }

    
    public Page<Tweet> list(@PageableDefault(page = 0, size = 5) Pageable page) {
        return repository.findAllByOrderByIdDesc(page);
    }
}
