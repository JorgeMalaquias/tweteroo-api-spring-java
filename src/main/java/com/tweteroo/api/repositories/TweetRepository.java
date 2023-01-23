package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.TweterooUser;

public interface TweetRepository extends JpaRepository<Tweet,Long>{

    List<Tweet> findByUserName(String userName); 
    Page<Tweet> findAllByOrderByIdDesc(Pageable page);
}
