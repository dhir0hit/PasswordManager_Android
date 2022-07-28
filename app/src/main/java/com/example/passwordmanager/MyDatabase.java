package com.example.passwordmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {platforms.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    abstract PassDao passDao();
    static MyDatabase instance;
    static MyDatabase getInstance(Context ctx){

        if (instance == null){
            instance = Room.databaseBuilder(ctx, MyDatabase.class,"My_DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
