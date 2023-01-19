package com.tweteroo.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tweteroo.api.dtos.TweetDTO;

import jakarta.persistence.Column;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO tweetData, String avatar) {
        this.userName = tweetData.userName();
        this.avatar = avatar;
        this.text = tweetData.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 150, nullable = false)
    private String text;
}
