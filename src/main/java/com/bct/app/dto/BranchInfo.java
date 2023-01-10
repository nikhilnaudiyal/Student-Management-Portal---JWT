package com.bct.app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="branch_info")
public class BranchInfo {


//	@OneToOne(targetEntity = StudentInfo.class)
//	StudentInfo studentInfo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="branch_code")
	private int branchCode;
	
	@Column(name="hod_name")
	private String hodName;
	
	@Column(name="branch_name")
	private String branchName;
	
	@OneToMany
	List<Subject> subject;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	
	
}
