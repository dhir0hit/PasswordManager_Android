package com.example.passwordmanager;

import android.content.Context;
import android.database.Observable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected static List<platforms> filterAll(String filterType){
        List<platforms> filterResult = null;
        LocalDate monthTime = LocalDate.now().plusDays(30);

        for (platforms platform: getAll){
            if(Objects.equals(filterType, "favorite" ) && platform.Favorite){
                // TODO: Add filter
                filterResult.add(platform);
            }
            else if(Objects.equals(filterType, "recent")){
                if(monthTime.isAfter(LocalDate.parse(platform.CreationDate))){}
                filterResult.add(platform);
            }
        }
        return null;
    }

    protected static void Delete(int Id){
        /*platforms account = find(Id);*/
        db.passDao().delete(Id);
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



    public userData(Context context) {
        db = MyDatabase.getInstance(context);
        getAll = db.passDao().getAll();
    }
}

