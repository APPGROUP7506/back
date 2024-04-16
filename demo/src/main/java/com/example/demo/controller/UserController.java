package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    //@ResponseBody
    public Result save(@RequestBody User user) {
        //User user = new User();

        int result = this.userService.insert(user);
        System.out.println("register:"+result);

        if(result==1) return Result.success();
        else return Result.error();
        //return ;
    }


    @RequestMapping("/login")
    //@ResponseBody
    public Result login(@RequestBody User user/*String username, String password*/){

        /*
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

         */
        int result = this.userService.login(user);
        System.out.println("login: "+result);

        if(result==1) return Result.success();
        else return Result.error();
    }
}

