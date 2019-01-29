package com.example.cct.designpatternsdemo.presenter;


import com.example.cct.designpatternsdemo.model.UserPres;

public class MainActivityPresenter {

	public interface View{

		void updateUserInfoTextView(String info);
		void showProgressBar();
		void hideProgressBar();

	}

	private UserPres userPres;
	private View view;

	public MainActivityPresenter(View view) {
		this.userPres = new UserPres();
		this.view = view;
	}

	public void updateFullName(String fullName){
		userPres.setFullName(fullName);
		view.updateUserInfoTextView(userPres.toString());
	}

	public void updateEmail(String email){
		userPres.setEmail(email);
		view.updateUserInfoTextView(userPres.toString());
	}

}
