package com.bct.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bct.app.dto.BranchInfo;
import com.bct.app.dto.Role;
import com.bct.app.dto.StudentInfo;
import com.bct.app.dto.Subject;
import com.bct.app.dto.User;
import com.bct.app.repository.BranchInfoRepo;
import com.bct.app.repository.RoleRepo;
import com.bct.app.repository.StudentInfoRepo;
import com.bct.app.repository.SubjectRepo;
import com.bct.app.repository.UserRepo;

@Service
public class StudentInfoService {

	@Autowired
	StudentInfoRepo studentInfoRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
//	@Autowired
//	User user;
//	
//	@Autowired
//	UserRepo userRepo;

	public ResponseEntity<String> saveStudent(StudentInfo student) {
		int id = student.getStudentId(); 
		if(studentInfoRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already exists");
		}
		else {
			
//			Role role = roleRepo.findById(2).get();
//			User userTemp = student.getUser();
//			
//			userTemp.setRole_assigned(role.getName());
//			userTemp.setStudentInfo(student);
			studentInfoRepo.save(student);
//			userRepo.save(userTemp);
			return ResponseEntity.status(HttpStatus.OK).body("Student record saved");
		}
	}

	public ResponseEntity<Object> getStudentInfo() {
		List<StudentInfo> studentList = studentInfoRepo.findAll();
		if (studentList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student List is Empty");
		}
		return ResponseEntity.of(Optional.of(studentList));
	}

	public List<StudentInfo> updateStudentInfo(@RequestBody StudentInfo studentInfo) {
		studentInfoRepo.save(studentInfo);
		return studentInfoRepo.findAll();
	}

	public void delete(int id) {
		studentInfoRepo.deleteById(id);
	}

	public ResponseEntity<Object> findById(int id) {
		//StudentInfo student = studentInfoRepo.findById(id).get();
		if(studentInfoRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(studentInfoRepo.findById(id).get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("STUDENT DOES NOT EXIST");
	}

	public ResponseEntity<Object> findByFirstName(String firstName) {
		List<StudentInfo> studentList = studentInfoRepo.findByFirstName(firstName);
		if(studentList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student with first name "+firstName+ " Does not Exist");
		}
		return ResponseEntity.status(HttpStatus.OK).body(studentInfoRepo.findByFirstName(firstName));
		
	}

	public ResponseEntity<Object>  findByMiddleName(String middleName) {
		List<StudentInfo> studentList = studentInfoRepo.findByMiddleName(middleName);
		if(studentList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student with middle name "+middleName+ " Does not Exist");
		}
		return ResponseEntity.status(HttpStatus.OK).body(studentInfoRepo.findByMiddleName(middleName));
	}

	public ResponseEntity<Object> findByLastName(String lastName) {
		List<StudentInfo> studentList = studentInfoRepo.findByLastName(lastName);
		if(studentList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student with first name "+lastName+ " Does not Exist");
		}
		return ResponseEntity.status(HttpStatus.OK).body(studentInfoRepo.findByLastName(lastName));
	}

	public StudentInfo updateStudentInfoById(StudentInfo studentInfo, int id) {
		StudentInfo studentInfo2 = studentInfoRepo.findById(id).get();
		studentInfo2.setFirstName(studentInfo.getFirstName());
		studentInfo2.setLastName(studentInfo.getLastName());
		studentInfo2.setAttendance(studentInfo.getAttendance());
		studentInfo2.setBranchCode(studentInfo.getBranchCode());
		studentInfo2.setMiddleName(studentInfo.getMiddleName());
		studentInfo2.setRollNumber(studentInfo.getRollNumber());
		return studentInfoRepo.save(studentInfo2);
	}

}
