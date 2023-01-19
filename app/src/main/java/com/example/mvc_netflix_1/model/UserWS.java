package com.example.mvc_netflix_1.model;


import com.example.mvc_netflix_1.model.pojo.User;

public class UserWS {
    private User user;
    public User getUserSW(){
        user = new User();
        user.setEmail("patata@gmail.com");
        user.setPassword("a");
        return user;
    }
}
