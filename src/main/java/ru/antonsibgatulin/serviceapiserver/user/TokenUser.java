package ru.antonsibgatulin.serviceapiserver.user;

import jakarta.persistence.*;

@Entity(name = "TokenUser")
public class TokenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   // private Long userId;
    @Column(name = "token",nullable = false,columnDefinition = "VARCHAR(500)")
    private String token;

    public TokenUser(Long id,/* Long userId, */ String token) {
        this.id = id;
        //this.userId = userId;
        this.token = token;
    }

    public TokenUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


 */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
