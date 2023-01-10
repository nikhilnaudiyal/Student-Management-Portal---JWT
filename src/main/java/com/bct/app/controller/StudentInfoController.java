//package com.bct.app.controller;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bct.app.dto.Subject;
//import com.bct.app.service.StudentInfoService;
//import com.bct.app.service.UserService;

//@CrossOrigin("http://localhost:8080")
//@RestController
//@PreAuthorize("hasRole('STUDENT')")
//public class StudentInfoController {
//
//	@Autowired
//	StudentInfoService studentInfoService;
//	
//	@Autowired
//	UserService userService;
//	
//
//	@GetMapping("/student/getsubject/{branch_id}")
//	public ResponseEntity<List<Subject>> getSubjectByBranchId(@PathVariable int branch_id) {
//		return studentInfoService.getSubjectByBranchId(branch_id);
//	}
//	
//	
//	@GetMapping("/student/getteacher/{branch_id}")
//	public ResponseEntity<String> getClassTeacherByBranchId(@PathVariable int branch_id) {
//		return studentInfoService.getClassTeacherByBranchId(branch_id);
//	}
//	
//	@GetMapping("/student/getfeedback/{branch_id}")
//	public ResponseEntity<String> getFeedbackByBranchId(@PathVariable int branch_id) {
//		return studentInfoService.getFeedbackByBranchId(branch_id);
//	}
//	
//}


package com.bct.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.app.dto.StudentInfo;
import com.bct.app.service.StudentInfoService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student/info")
public class StudentInfoController {

	@Autowired
	StudentInfoService studentInfoService;
	
	@PostMapping(path="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveStudent(@RequestBody StudentInfo student) {
		return studentInfoService.saveStudent(student);
	}
	
	@GetMapping(path="/get",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudentInfo() {
		return  studentInfoService.getStudentInfo();
	}
	
	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentInfo> updateStudentInfo(@RequestBody StudentInfo studentInfo) {
		return studentInfoService.updateStudentInfo(studentInfo);		
	}
	
	@PutMapping(path = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentInfo updateStudentInfoById(@RequestBody StudentInfo studentInfo, @PathVariable int id) {
		return studentInfoService.updateStudentInfoById(studentInfo, id);		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		studentInfoService.delete(id);
	}
	
	@GetMapping(path = "/find/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		return studentInfoService.findById(id);
	}
	
	@GetMapping(path="/find/fname/{name}")
	public ResponseEntity<Object> findByFirstName(@PathVariable("name") String firstName){
		return studentInfoService.findByFirstName(firstName);
	}
	
	@GetMapping(path="/find/mname/{name}")
	public ResponseEntity<Object>  findByMiddleName(@PathVariable("name") String middleName){
		return studentInfoService.findByMiddleName(middleName);
	}
	
	@GetMapping(path="/find/lname/{name}")
	public ResponseEntity<Object>  findByLastName(@PathVariable("name") String lastName){
		return studentInfoService.findByLastName(lastName);
	}
	
}
	

