package com.example.cct.designpatternsdemo.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.cct.designpatternsdemo.Repository.UserRepository;
import com.example.cct.designpatternsdemo.model.UserModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepositoryVM;
    private LiveData<List<UserModel>> mAllUsersVM;
    private LiveData<UserModel> mUserDataVM;
    private LiveData<UserModel> mFirstUserVM;

    public UserViewModel(@NonNull Application application) {
        super(application);

        this.mUserRepositoryVM = new UserRepository(application);
    }

    public void insertUserVM(UserModel userModel){
        mUserRepositoryVM.insertUser(userModel);
    }

    public LiveData<List<UserModel>> getmAllUsersVM(){
        mAllUsersVM = mUserRepositoryVM.getAllUsers();
        return mAllUsersVM;
    }

    public LiveData<UserModel> getUserDataVM(int UserID){
        mUserDataVM = mUserRepositoryVM.getUserData(UserID);
        return mUserDataVM;
    }

    public LiveData<UserModel> getFirstUserVM(){
        mFirstUserVM = mUserRepositoryVM.getFirstUser();
        return mFirstUserVM;
    }

    public void updateUser(UserModel userModel){
        mUserRepositoryVM.updateUser(userModel);
    }

}
