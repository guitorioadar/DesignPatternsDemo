package com.example.cct.designpatternsdemo.model;

public class UserPres {private String fullName = "", email = "";

	public UserPres() {
	}

	public UserPres(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FullName : " + fullName+"\nEmail : " + email;
	}
}