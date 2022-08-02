package com.example.passwordmanager;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class platforms {
    @NonNull
    @PrimaryKey
    int id;
    String PlatformName;
    String UserName;
    String Email;
    String Password;
    String Website;
    String AdditionalInfo;
    boolean Favorite;
    String CreationDate;
    String EditDate;


    public platforms(){}

    public platforms(int id, String platformName, String userName, String email, String password, String website, String additionalInfo) {
        this.id = id;
        PlatformName = platformName;
        UserName = userName;
        Email = email;
        Password = password;
        Website = website;
        AdditionalInfo = additionalInfo;
        Favorite = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CreationDate = LocalDate.now().toString();
            EditDate = LocalDate.now().toString();
        }
    }
}



















