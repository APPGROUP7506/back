package com.example.demo.service;

import com.example.demo.entity.User;


public interface UserService {

    int insert(User user);


    int login(User user);
}
