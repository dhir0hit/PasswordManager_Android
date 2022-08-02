package com.example.passwordmanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class login {

    @PrimaryKey
    int id;
    String userName;
    String password;

    public login(){}

    public login(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }
}
