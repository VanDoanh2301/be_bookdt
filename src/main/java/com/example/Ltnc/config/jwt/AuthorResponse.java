package com.example.Ltnc.config.jwt;

import lombok.Data;

import java.util.Collection;

@Data
public class AuthorResponse {
    private String token;
    private  String username;
    private Collection<String> roles;

    public AuthorResponse(String token) {
        this.token = token;
    }

    public AuthorResponse(String token, String username, Collection<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

}
