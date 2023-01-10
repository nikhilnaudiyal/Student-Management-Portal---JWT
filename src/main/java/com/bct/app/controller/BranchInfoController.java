package com.bct.app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import com.bct.app.dto.BranchInfo;
import com.bct.app.service.BranchInfoService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/branch")

public class BranchInfoController {

	@Autowired
	BranchInfoService branchInfoService;

	@PostMapping(path = "/savebranch", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveBranch(@RequestBody BranchInfo branch) {
		branchInfoService.saveBranch(branch);
	}

	@GetMapping(path = "/getbranch", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BranchInfo> getBranch() {
		return branchInfoService.getBranch();
	}

}