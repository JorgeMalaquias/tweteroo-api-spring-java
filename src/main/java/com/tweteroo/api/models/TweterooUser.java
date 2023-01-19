package com.tweteroo.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tweteroo.api.dtos.UserDTO;

import jakarta.persistence.Column;

@Data
@Entity
@NoArgsConstructor
public class TweterooUser {

    public TweterooUser(UserDTO data) {
        this.userName = data.userName();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String avatar;
}