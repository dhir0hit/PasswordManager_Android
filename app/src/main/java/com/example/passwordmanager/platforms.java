package com.example.passwordmanager;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class platforms {
    @NonNull
    @PrimaryKey
    int id;
    String PlatformName;
    String UserName;
    String Email;
    String Password;
    String AdditionalInfo;


    public platforms(){}
    public platforms(int id, String platformName, String userName, String email, String password, String additionalInfo){
        this.id = id;
        PlatformName = platformName;
        UserName = userName;
        Email = email;
        Password = password;
        AdditionalInfo = additionalInfo;
    }
}
