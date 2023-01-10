package com.bct.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.app.dto.BranchInfo;
import com.bct.app.repository.BranchInfoRepo;

@Service
public class BranchInfoService {

	@Autowired
	BranchInfoRepo branchInfoRepo;
	
	public void saveBranch(BranchInfo branch) {
		branchInfoRepo.save(branch);
	}
	
	public List<BranchInfo> getBranch(){
		return branchInfoRepo.findAll();
	}
}
