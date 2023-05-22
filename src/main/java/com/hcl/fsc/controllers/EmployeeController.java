package com.hcl.fsc.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.hcl.fsc.entities.NonTier_1;
import com.hcl.fsc.excel.vivo.EmployeeDetails;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.services.EmployeeNonTier_1ServiceImpl;

@RestController
public class EmployeeController {
	
	
    @Autowired
    private EmployeeNonTier_1ServiceImpl employeeService;

    @PostMapping("fsc/upload")
	public ResponseEntity<?> employeeNonTier1Uplaod(@RequestParam("file") MultipartFile[] file) {
		int count=0;
		for(int i=0; i<file.length; i++) {
		if (EmployeeHelper.checkExcelFormate(file[i])) {
			int res=this.employeeService.employeeNonTier1ListSave(file[i]);
			if(res==1) {
				count++;
			}
		}
		else
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");
	}
		if(count==file.length)
	         return ResponseEntity.ok(Map.of("message", "All files are uploaded"));
	else
		    return ResponseEntity.ok(Map.of("message", file.length-count+"File is not uploaded maybe some values are null"));
	}
	@GetMapping("/employeesList")
	public List<EmployeeDetails> getAllEmployeesDetails(){
		return this.employeeService.getAllEmployees();
	}
	@GetMapping("/employeeNonTier1List")
	public List<NonTier_1> getAllProduct(){
		return this.employeeService.getAllNonTier1Employees();
	}
}
