package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @date 2021/5/21 12:12
 */
public interface UserService {

    int insert(User user);

    /*
    int deleteById(Integer id);

    int update(User user);

    User getById(Integer id);

     */
    int login(User user);
}
