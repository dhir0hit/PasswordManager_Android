package com.example.passwordmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PassDao {
    @Query("SELECT * FROM platforms")
    List<platforms> getAll();

    @Insert
    void insert(platforms p);
}
