package com.example.passwordmanager;

import android.database.Observable;

import java.util.List;
import java.util.Objects;


public class userData {

    private static MyDatabase db;
    public static List<platforms> getAll = db.passDao().getAll() ;

    protected String find(int id){
        platforms obj = new platforms();
        if(id == obj.id){
            Account account = new Account(obj.id, obj.PlatformName, obj.UserName, obj.Password, obj.Email, obj.Website, obj.AdditionalInfo, obj.Favorite, obj.CreationDate, obj.EditDate);
            return obj.UserName;
        }
        return null;
    }

    protected String[] filterAll(String filterType){
        platforms obj = new platforms();
        for (platforms platform: getAll){
            if(Objects.equals(filterType, "favorite")){
                // TODO: Add filter
//                String[] account = new String[]{obj.id, obj.PlatformName, obj.UserName, obj.Password, obj.Email, obj.Website, obj.AdditionalInfo};
//                return account;
            }
            else if(Objects.equals(filterType, "recent")){
//                String[] account = new String[]{obj.id, obj.PlatformName, obj.UserName, obj.Password, obj.Email, obj.Website, obj.AdditionalInfo};
//                return account;
            } else {
                return null;
            }
        }
        return null;
    }


}

