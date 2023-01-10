package com.bct.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.dto.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
