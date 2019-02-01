package com.example.cct.designpatternsdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.amitshekhar.DebugDB;
import com.example.cct.designpatternsdemo.ViewModel.UserViewModel;
import com.example.cct.designpatternsdemo.model.UserModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private TextView textView;
    private EditText etName, etEmail;
    private UserViewModel userViewModel;
    private ListView listView;

    private String alreadyCreated = "false";
    private Button button;
    private int userid;

    private UserModel gUserModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gUserModel = new UserModel();

        Log.d(TAG, "onCreate: Database: " + DebugDB.getAddressLog());

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        textView = findViewById(R.id.textView);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userModel = new UserModel();
                userModel.setUserName(etName.getText().toString());
                userModel.setUserEmail(etEmail.getText().toString());

                userViewModel.insertUserVM(userModel);
            }
        });

        userViewModel.getFirstUserVM().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if (userModel!=null) {
                    textView.setText("Id: " + userModel.getUserID() + " Name: " + userModel.getUserName() + " Email: " + userModel.getUserEmail());
                    gUserModel.setUserID(userModel.getUserID());
                    gUserModel.setUserName(userModel.getUserName());
                    gUserModel.setUserEmail(userModel.getUserEmail());
                    alreadyCreated = "true";
                }else {
                    textView.setText("Empty");
                }
            }
        });

        userViewModel.getmAllUsersVM().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(@Nullable List<UserModel> userModel) {
                if (userModel!=null) {
                    Log.d(TAG, "onChanged: "+userModel.toString());
                }else {
                    Log.d(TAG, "onChanged: Empty");
                }
            }
        });

        /*userViewModel.getUserDataVM().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if (!userModel.toString().isEmpty()){
                    textView.setText(userModel.toString());
                }
            }
        });*/

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (alreadyCreated.equals("true")) {
                    UserModel userModel = new UserModel();
                    userModel.setUserID(gUserModel.getUserID());
                    userModel.setUserName(s.toString());
                    userModel.setUserEmail(gUserModel.getUserEmail());
                    userViewModel.updateUser(userModel);
                    userModel = null;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (alreadyCreated.equals("true")) {
                    UserModel userModel = new UserModel();
                    userModel.setUserID(gUserModel.getUserID());
                    userModel.setUserName(gUserModel.getUserName());
                    userModel.setUserEmail(s.toString());
                    userViewModel.updateUser(userModel);
                    userModel = null;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}
