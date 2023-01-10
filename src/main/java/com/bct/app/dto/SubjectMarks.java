package com.bct.app.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="subject_marks")
public class SubjectMarks {
	
//	@OneToOne(targetEntity = StudentInfo.class)
//	StudentInfo studentInfo;
	
	
	@Column(name="student_id")
	private int studentId;
	
	@Id
	@Column(name="subject_code")
	private int subjectCode;
	
	@Column(name="obtained_marks")
	private int obtainedMarks;
	
	@Column(name="maximum_marks")
	private int maximumMarks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public int getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
	}
	
	

}
