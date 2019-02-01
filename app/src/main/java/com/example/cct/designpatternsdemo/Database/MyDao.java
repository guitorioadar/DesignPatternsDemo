package com.example.cct.designpatternsdemo.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cct.designpatternsdemo.model.UserModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MyDao {

    @Insert(onConflict = REPLACE)
    void insertUserDataArray(UserModel... userModels);

    @Insert
    public void insertUserData(UserModel userModel);

    @Query("select * from UserModel")
    LiveData<List<UserModel>> getAllUsers();

    @Query("select * from UserModel where UserID = :UserID")
    public LiveData<UserModel> getUserData(int UserID);

    @Query("select * from UserModel Order by UserID DESC limit 1")
    public LiveData<UserModel> getFirstUser();

    @Update
    public void updateUser(UserModel userModel);

    @Delete
    public void deleteUser(UserModel userModel);

}
