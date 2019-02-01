package com.example.cct.designpatternsdemo.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "UserModel")
public class UserModel {

    @ColumnInfo(index = true)
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int UserID;

    @ColumnInfo(name = "UserName")
    private String UserName;

    @ColumnInfo(name = "UserEmail")
    private String UserEmail;

    public UserModel() {
    }


    @NonNull
    public int getUserID() {
        return UserID;
    }

    public void setUserID(@NonNull int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: "+UserID+" UserName: " + UserName  +" UserEmail: " + UserEmail;

        /*return "UserName='" + UserName + '\'' +
                ", UserEmail='" + UserEmail + '\'' +
                '}';*/
    }
}
