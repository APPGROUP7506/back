package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String email;

    private String phone;

    private String hkuid;

    private String username;

    private String password;

   /*email, phone, hkuid, username, password*/
}
