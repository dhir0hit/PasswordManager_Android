package com.example.passwordmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PassDao {
    @Query("SELECT * FROM platforms")
    List<platforms> getAll();

    @Insert
    void insert(platforms p);


    @Query("DELETE FROM platforms WHERE id = :id")
    void delete(int id);



    @Query("UPDATE platforms SET PlatformName = :platformName, " +
            "UserName =:userName, " +
            "Email =:email, " +
            "Password =:password, " +
            "Website =:website, " +
            "AdditionalInfo =:additionalInfo, " +
            "Favorite =:favorite, " +
            "EditDate =:editDate " +
            "WHERE id = :Id")
    void updateAll(int Id, String platformName, String userName, String email, String password, String website, String additionalInfo, boolean favorite, String editDate);

    @Query("UPDATE platforms SET Favorite =:favorite, EditDate =:editDate WHERE id =:Id")
    void updateFavorite(int Id, boolean favorite, String editDate);
}


















