package com.example.cct.designpatternsdemo.controller;

import com.example.cct.designpatternsdemo.MainActivity;
import com.example.cct.designpatternsdemo.model.Student;

public class StudentController {

	private Student model;
	private MainActivity view;

	public StudentController(Student model, MainActivity view) {
		this.model = model;
		this.view = view;
	}

	public void setStudentName(String name){
		model.setName(name);
	}
	public String getStudentName(){
		return model.getName();
	}

	public void setStudentRoll(String roll){
		model.setRollNo(roll);
	}

	public String getStudentRoll(){
		return model.getRollNo();
	}


	public void updateView(){
		view.printStudentDetails(model.getName(),model.getRollNo());
	}

}
