package com.example.cct.designpatternsdemo.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.cct.designpatternsdemo.model.UserModel;

@Database(entities = {UserModel.class},version = 1, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

    private static MyAppDatabase INSTANCE;

    public static MyAppDatabase getDatabase (Context context){
        if (INSTANCE == null){
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),MyAppDatabase.class,"user_info")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
