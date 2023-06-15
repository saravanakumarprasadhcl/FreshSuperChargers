package com.hcl.fsc.controllers;

import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.services.EmployeeMoUService;
import com.hcl.fsc.services.EmployeeSkilledHiringService;
import com.hcl.fsc.services.EmployeeTier1Service;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	private EmployeeTier1Service tier_1Service;

	@Autowired
	private EmployeeSkilledHiringService skilledHiringService;

	@Autowired
	private EmployeeMoUService mouService;

	@Autowired
	private EmployeeRecruitmentDetailsRepository employeeRecruitmentDetailsRepository;

	@PostMapping("fsc/uploads")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if (EmployeeHelper.checkExcelFormate(file)) {
			this.tier_1Service.save(file);
			this.skilledHiringService.save(file);
			this.mouService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Upload");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");
	}

	@GetMapping("/employees")
	public List<EmployeeRecruitmentDetails> getAllEmployeesUnassigned(){
		return employeeRecruitmentDetailsRepository.findAll();
	}

}