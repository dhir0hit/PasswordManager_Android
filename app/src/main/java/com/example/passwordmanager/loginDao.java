package com.example.passwordmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface loginDao {
    @Query("SELECT * FROM login")
    List<login> getAll();

    @Insert
    void insert(login l);

    @Query("UPDATE login SET userName = :username, password = :passWord")
    void updateLogin(String username, String passWord);


}
