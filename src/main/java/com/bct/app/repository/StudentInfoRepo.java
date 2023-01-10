package com.bct.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.dto.StudentInfo;

@Repository
public interface StudentInfoRepo extends JpaRepository<StudentInfo, Integer>{

	public List<StudentInfo> findByFirstName(String firstName);
	
	public List<StudentInfo> findByMiddleName(String middleName);
	
	public List<StudentInfo> findByLastName(String lastName);
}
