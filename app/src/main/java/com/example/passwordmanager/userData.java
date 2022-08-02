package com.example.passwordmanager;

import android.content.Context;
import android.database.Observable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class userData {

//    private static Context context;

    public static MyDatabase db;
    public static List<platforms> getAll = null ;

    protected static platforms find(int id){
        for (platforms account: userData.getAll){
            if(id == account.id){
                return account;
            }
        }
        return null;
    }

    protected static void addAccount(int id, String platform, String username, String email, String password, String website, String info){
        platforms platforms = new platforms(id, platform, username, email, password, website, info);
        db.passDao().insert(platforms);
    }

    protected static List<platforms> filterAll(String filterType){
        List<platforms> filterResult = new ArrayList<>();
        LocalDate monthTime = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            monthTime = LocalDate.now().plusDays(30);
        }

        if (filterType.equals("all")){
          filterResult = getAll;
        } else{
            for (platforms platform: getAll){
                if(Objects.equals(filterType, "favorite" )){

                    if (platform.Favorite){
                        // TODO: Add filter
                        filterResult.add(platform);
                    }
                }
                else if(Objects.equals(filterType, "recent")){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        if(monthTime.isAfter(LocalDate.parse(platform.CreationDate))){
                            filterResult.add(platform);
                        }
                    }
                }
            }
        }
        return filterResult;
    }

    protected static void Delete(int Id){
        platforms account = find(Id);
        db.passDao().delete(account);
    }

    protected static void UpdateAll(int Id, String platform, String userName, String email, String Password, String website, String info, boolean favorite){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            db.passDao().updateAll(
                    Id, platform, userName, email, Password, website, info, favorite,
                    LocalDate.now().toString()
            );
        }
    }

    protected static void UpdateFavorite(int Id, boolean favorite){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            db.passDao().updateFavorite(
                    Id,
                    favorite,
                    LocalDate.now().toString()
            );
        }
    }


    protected static void newLogin(String username, String password){
        login l = new login(username, password);
        db.logindao().insert(l);
    }

    protected static login getLoginUser(){
        List<login> loginlist = db.logindao().getAll();

        login user;

        try {
            user = loginlist.get(0);
        } catch (IndexOutOfBoundsException exception){
            user = null;
        }
        return user;
    }

    protected static void updateLogin(String user, String pass){
        db.logindao().updateLogin(user,pass);
    }

    public userData(Context context) {
        db = MyDatabase.getInstance(context);
        getAll = db.passDao().getAll();
    }
}

