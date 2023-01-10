package com.bct.app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_info")
public class StudentInfo {

//	@OneToOne(targetEntity= SubjectMarks.class, fetch = FetchType.LAZY)
//	//@JoinColumn(name = "studentId")
//	SubjectMarks subjectMarks;

//	@OneToMany(targetEntity = Subject.class)
////	@JoinColumn(name = "subjectCode")
//	List<Subject> subject;

//	@ManyToOne
//	// @JoinColumn(name = "branchId")
//	BranchInfo branchInfo;

//	@OneToOne
//	User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stud_id")
	private int studentId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "branch_code")
	private int branchCode;

	@Column(name = "attendance")
	private float attendance;

	@Column(name = "roll_number")
	private String rollNumber;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public float getAttendance() {
		return attendance;
	}

	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	
	

}
