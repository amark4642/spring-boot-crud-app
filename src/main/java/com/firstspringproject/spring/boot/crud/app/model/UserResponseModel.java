package com.firstspringproject.spring.boot.crud.app.model;

import java.util.Optional;

import com.firstspringproject.spring.boot.crud.app.entitiy.User;


public class UserResponseModel {
    
    public String status;
    public Integer responseCode;
    public Optional<User> data;

    public UserResponseModel(String status, Integer responseCode, Optional<User> data) {
        super();
        this.status = status;
        this.responseCode = responseCode;
        this.data = data;
    }

    public UserResponseModel() {
        super();
    }

}