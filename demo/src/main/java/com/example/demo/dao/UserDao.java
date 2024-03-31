package com.example.demo.dao;

import com.example.demo.entity.User;

/**
 * @date 2021/5/21 9:21
 */
public interface UserDao {

    /**增**/
    int insert(User user);
    /**删**/
    int deleteById(Integer id);
    /**改**/
    int update(User user);
    /**查**/
    User getById(Integer id);
    /**登录**/
    User login(String username, String password);

}
