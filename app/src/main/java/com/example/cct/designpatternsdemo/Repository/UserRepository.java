package com.example.cct.designpatternsdemo.Repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.cct.designpatternsdemo.Database.MyAppDatabase;
import com.example.cct.designpatternsdemo.Database.MyDao;
import com.example.cct.designpatternsdemo.model.UserModel;

import java.util.List;

public class UserRepository {

    private MyDao myDao;
    private LiveData<List<UserModel>> mAllUserRepo;
    private LiveData<UserModel> mUserData;
    private LiveData<UserModel> mFirstUser;

    /*
    * constructor
    * */
    public UserRepository(Application application){
        MyAppDatabase myAppDatabase = MyAppDatabase.getDatabase(application);
        myDao = myAppDatabase.myDao();
    }

    /*
    * Read data
    * */
    public LiveData<List<UserModel>> getAllUsers(){
        mAllUserRepo = myDao.getAllUsers();
        return mAllUserRepo;
    }

    /*
    * Read Data
    * */
    public LiveData<UserModel> getUserData(int UserID){
        mUserData = myDao.getUserData(UserID);
        return mUserData;
    }

    /*
    * First User
    * */
    public LiveData<UserModel> getFirstUser(){
        mFirstUser = myDao.getFirstUser();
        return mFirstUser;
    }

    /*
     * insert Users
     * */
    public void insertUser(UserModel userModel){
        new insertAsynkTask(myDao).execute(userModel);
    }

    private static class insertAsynkTask extends AsyncTask<UserModel,Void,Void> {

        private MyDao myAsynkDao;
        public insertAsynkTask(MyDao myDao) {
            myAsynkDao = myDao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {

            myAsynkDao.insertUserData(userModels[0]);
            return null;
        }
    }

    /*
    * update userdata
    * */
    @SuppressLint("StaticFieldLeak")
    public void updateUser(final UserModel userModel){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDao.updateUser(userModel);
                return null;
            }
        }.execute();
    }
}
