package com.example.cct.designpatternsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.cct.designpatternsdemo.controller.StudentController;
import com.example.cct.designpatternsdemo.model.Student;

public class MainActivity extends AppCompatActivity {

	private String TAG = "MainActivity";
	StudentController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Student model = retrieveStudentFromDatabase();
		MainActivity view = this;

		controller = new StudentController(model,view);

		controller.updateView();




	}

	private Student retrieveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}

	public void printStudentDetails(String studentName, String studentRollNo){

		Log.d(TAG, "printStudentDetails: "+"Student: ");
		Log.d(TAG, "printStudentDetails: "+"Name: " + studentName);
		Log.d(TAG, "printStudentDetails: "+"Roll No: " + studentRollNo);

	}

	public void updateUI(View view) {

		// update model data
		controller.setStudentName("Rusho");
		controller.setStudentRoll("12");
		controller.updateView();

	}
}
