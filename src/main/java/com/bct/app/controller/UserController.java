//package com.bct.app.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bct.app.dto.BranchInfo;
//import com.bct.app.dto.StudentInfo;
//import com.bct.app.dto.Subject;
//
//import com.bct.app.payloads.ApiResponse;
//import com.bct.app.repository.BranchInfoRepo;
//import com.bct.app.service.StudentInfoService;
//
//import com.bct.app.service.UserService;
//
//@RestController
//@org.springframework.transaction.annotation.Transactional
//@RequestMapping("/admin")
//@CrossOrigin
//@PreAuthorize("hasRole('ADMIN')")
//public class UserController {
//
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	StudentInfoService studentInfoService;
//
//	@Autowired
//	BranchInfoRepo branchInfoRepo;
//
//	// post-create user
//	@PostMapping("/addstudent")
//	public ResponseEntity<String> saveStudentInfo(@Valid @RequestBody StudentInfo studentInfo) {
//		return userService.saveStudentInfo(studentInfo);
//	}
//
//	// put-update user
//	@PutMapping("/updatestudent/{student_id}")
//	public StudentInfo updateStudentInfo(@Valid @RequestBody StudentInfo studentInfo, @PathVariable int student_id) {
//		return userService.updateStudentInfo(studentInfo, student_id);
//	}
//
//	// delete - delete user
//
//	// @DeleteMapping("/deletestudent/{student_id}")
////	public void deleteStudentInfo(@PathVariable int student_id) {
////		userService.deleteStudentInfo(student_id);
//
////	public void deleteStudentInfo(@PathVariable int student_id) {
////		userService.deleteStudentInfo(student_id);
////	}
//
//	@GetMapping("/getstudent")
//	public ResponseEntity<List<StudentInfo>> getStudentInfo() {
//		return userService.getStudentInfo();
//	}
//
//	// get-user get
//	@GetMapping("/getstudent/{student_id}")
//	public ResponseEntity<Object> getStudentInfoById(@PathVariable int student_id) {
//		return userService.getStudentInfoById(student_id);
//	}
//
//	@GetMapping("/branchinfo")
//	public List<BranchInfo> getBranchInfo() {
//		return branchInfoRepo.findAll();
//	}
//
//	@DeleteMapping("/deleteuser/{user_id}")
//	public void deleteStudentInfo(@PathVariable int user_id) {
//		userService.deleteStudentInfo(user_id);
//	}
//
//	@PostMapping("/addsubject")
//	public Subject saveSubject(@RequestBody Subject subject) {
//		return userService.saveSubject(subject);
//	}
//
//	@DeleteMapping("/deletesubject/{subject_id}")
//	public void deleteSubject(@PathVariable int subject_id) {
//		userService.deleteSubject(subject_id);
//	}
//}
