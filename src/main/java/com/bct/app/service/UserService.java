//package com.bct.app.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.bct.app.dto.Role;
//import com.bct.app.dto.StudentInfo;
//import com.bct.app.dto.Subject;
//import com.bct.app.dto.User;
//
//import com.bct.app.repository.RoleRepo;
//import com.bct.app.repository.StudentInfoRepo;
//import com.bct.app.repository.SubjectRepo;
//import com.bct.app.repository.UserRepo;
//
//@Service
//public class UserService {
//	
//	@Autowired
//	UserRepo userRepo;
//	
//	@Autowired
//	StudentInfoRepo studentInfoRepo;
//	
//	@Autowired
//	SubjectRepo subjectRepo;
//	
//	@Autowired
//	 PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	 RoleRepo roleRepo;
//
//	public ResponseEntity<String> saveStudentInfo(StudentInfo studentInfo) {
//		User user = studentInfo.getUser();
//		String email = user.getEmail();
//		String password = user.getPassword();
//		String username = user.getUsername();
//		if (userRepo.existsByEmail(email) || userRepo.existsByUsername(username)) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already exists");
//		} else {
//
//			user.setPassword(passwordEncoder.encode(password));
//
//			Role role = this.roleRepo.findById(2).get();
//			user.getRole().add(role);
//
//			user.setActive(true);
//			userRepo.save(user);
//			studentInfoRepo.save(studentInfo);
//			return ResponseEntity.status(HttpStatus.CREATED).body("Student Record is saved");
//		}
//	}
//
//	public ResponseEntity<List<StudentInfo>> getStudentInfo() {
//		List<StudentInfo> studentInfoList = studentInfoRepo.findAll();
//		if (studentInfoList.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(studentInfoList));
//	}
//
//	public void deleteStudentInfo(int user_id) {
//		User user = userRepo.findById(user_id).get();
//		user.setActive(false);
//		userRepo.save(user);
//	}
//	
//	public StudentInfo updateStudentInfo(StudentInfo studentInfo, int student_id) {
//		if (studentInfoRepo.existsById(student_id)) {
//
//			StudentInfo updatedStudentInfo = studentInfoRepo.findById(student_id).get();
//			int user_id = updatedStudentInfo.getUser().getUser_id();
//
//			studentInfo.setStudentId(student_id);
//			studentInfo.getUser().setUser_id(user_id);
//
//			return studentInfoRepo.save(studentInfo);
//
//		} else {
//			System.out.println("No Data found");
//		}
//		return null;
//	}
//	public ResponseEntity<Object> getStudentInfoById(int student_id) {
//		// StudentInfo student = studentInfoRepo.findById(id).get();
//		if (studentInfoRepo.existsById(student_id)) {
//			return ResponseEntity.status(HttpStatus.OK).body(studentInfoRepo.findById(student_id).get());
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("STUDENT  with id " + student_id + " DOES NOT EXIST");
//	}
//	
//
//	public Subject saveSubject(Subject subject) {
//		return subjectRepo.save(subject);
//	}
//
//	public void deleteSubject(int subject_id) {
//		subjectRepo.deleteById(subject_id);
//	}
//
//}
//
