package com.bct.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.dto.BranchInfo;

@Repository
public interface BranchInfoRepo extends JpaRepository<BranchInfo, Integer>{

}
