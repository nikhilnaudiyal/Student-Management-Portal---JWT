package com.bct.app;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bct.app.dto.BranchInfo;
import com.bct.app.dto.Role;
import com.bct.app.dto.StudentInfo;
import com.bct.app.dto.User;
import com.bct.app.repository.BranchInfoRepo;
import com.bct.app.repository.RoleRepo;
import com.bct.app.repository.StudentInfoRepo;
import com.bct.app.repository.UserRepo;





@SpringBootApplication
public class StudentManagementPortalApplication implements CommandLineRunner {

	@Autowired
	BranchInfoRepo branchInfoRepo;
	
	@Autowired
	StudentInfoRepo studentInfoRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementPortalApplication.class, args);
	}
	
//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}

	@Override
	public void run(String... args) throws Exception {
		
		if(userRepo.count() == 0 && branchInfoRepo.count() == 0 && roleRepo.count() == 0) {
		BranchInfo branchInfo = new BranchInfo();
		branchInfo.setBranchCode(1);
		branchInfo.setBranchName("CS");
		branchInfo.setHodName("ABC");
		branchInfoRepo.save(branchInfo);
		
		BranchInfo branchInfo1 = new BranchInfo();
		branchInfo1.setBranchCode(2);
		branchInfo1.setBranchName("IT");
		branchInfo1.setHodName("XYZ");
		branchInfoRepo.save(branchInfo1);
		
		BranchInfo branchInfo2 = new BranchInfo();
		branchInfo2.setBranchCode(3);
		branchInfo2.setBranchName("Mech");
		branchInfo2.setHodName("PQR");
		branchInfoRepo.save(branchInfo2);
		
		System.out.println(this.passwordEncoder.encode("akanksha"));
		
		User user = new User();
	    user.setDob("13/11/2000");
	    user.setContact("9998887689");
	    user.setGender("Female");
	    user.setPassword(this.passwordEncoder.encode("admin"));
	    user.setRole_assigned("ADMIN");
	    user.setEmail("akanksha@gmail.com");
	    user.setUsername("akanksha@gmail.com");
	    user.setActive(true);
	    
//	    StudentInfo studentInfo = new StudentInfo();
//	    studentInfo.setRoll_number(111);
//	    studentInfo.setBranchInfo(branchInfo1);
//	    studentInfo.setUser(user);
//	    studentInfoRepo.save(studentInfo);
	    
		
		Role role_admin = new Role("ROLE_ADMIN");
	    
	    Role role_student = new Role("ROLE_STUDENT");
	    
	    roleRepo.save(role_admin);
	    roleRepo.save(role_student);
	    
	    
	    
	    Role role = this.roleRepo.findById(1).get();
        user.getRole().add(role);
        userRepo.save(user);
        
        System.out.println("Created Default");
		
	}else {
		System.out.println("Already default created");
	}

	
	}	
}
