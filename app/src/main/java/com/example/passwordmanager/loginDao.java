package com.example.passwordmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface loginDao {
    @Query("SELECT * FROM login")
    List<login> getAll();

    @Insert
    void insert(login l);


}
