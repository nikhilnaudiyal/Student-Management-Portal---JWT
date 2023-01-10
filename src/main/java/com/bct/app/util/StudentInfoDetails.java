package com.bct.app.util;

import com.bct.app.dto.StudentInfo;
import com.bct.app.dto.User;

public class StudentInfoDetails {
private StudentInfo studentInfo;
	
	private User user;

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudent(StudentInfo student) {
		this.studentInfo = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
