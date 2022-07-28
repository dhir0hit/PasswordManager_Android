package com.example.passwordmanager;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public class PassDao {
    @Query("SELECT * FROM platforms")
    List<platforms> getAll() {
      return null;
    }

    @Insert
    void insert(platforms p) {
        

    }
}
