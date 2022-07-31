package com.example.passwordmanager;

public class Account {
    int id;
    String PlatformName;
    String UserName;
    String Email;
    String Password;
    String Website;
    String AdditionalInfo;
    Boolean Favorite;
    String CreationDate;
    String EditDate;

    public Account() {
    }

    public Account(int id, String platformName, String userName, String email, String password, String website, String additionalInfo) {
        this.id = id;
        PlatformName = platformName;
        UserName = userName;
        Email = email;
        Password = password;
        Website = website;
        AdditionalInfo = additionalInfo;
    }

    public Account(int id, String platformName, String userName, String email, String password, String website, String additionalInfo, Boolean favorite, String creationDate, String editDate) {
        this.id = id;
        PlatformName = platformName;
        UserName = userName;
        Email = email;
        Password = password;
        Website = website;
        AdditionalInfo = additionalInfo;
        Favorite = favorite;
        CreationDate = creationDate;
        EditDate = editDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatformName() {
        return PlatformName;
    }

    public void setPlatformName(String platformName) {
        PlatformName = platformName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public Boolean getFavorite() {
        return Favorite;
    }

    public void setFavorite(Boolean favorite) {
        Favorite = favorite;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getEditDate() {
        return EditDate;
    }

    public void setEditDate(String editDate) {
        EditDate = editDate;
    }
}
