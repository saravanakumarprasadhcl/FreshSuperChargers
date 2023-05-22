package com.hcl.fsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.services.EmployeeNonTier_1ServiceImpl;

@RestController
public class MasterTableController {
	
	@Autowired
	private EmployeeNonTier_1ServiceImpl employeeService;
	
	@GetMapping("master/gender")
	public List<Gender> getMasterGenderTable() {
		return this.employeeService.getAllGender();
		
	}
	
	@PostMapping("master/gender")
	public Gender addGender(@RequestBody Gender gender) {
		return this.employeeService.addGender(gender);
		
	}

}
