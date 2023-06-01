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
import com.hcl.fsc.entities.Employee;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.services.MasterTableServiceImpl;

@RestController
public class EmployeeController {
	
	
    @Autowired
    private MasterTableServiceImpl candidateService;
    @PostMapping("candidatesList/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile[] file) {
		System.out.println(file.length+"no. of files");
		int count=0;
		for(int i=0; i<file.length; i++) {
		if (EmployeeHelper.checkExcelFormate(file[i])) {
			int res=this.candidateService.save(file[i]);
			if(res==1) {
				count++;
			}
		}
		else
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");
	}
		if(count==file.length)
	         return ResponseEntity.ok(Map.of("message", "All files are uploaded"));
//	else if(res==-1) {
//		    int count=this.productService.getStatus();
//			return ResponseEntity.ok(Map.of("message", "File is uploaded partially "+count+" row in excel sheet have some improper data"));
//	}
	else
		    return ResponseEntity.ok(Map.of("message", file.length-count+"File is not uploaded maybe some values are null"));
	}
//	@GetMapping("/candidatesList")
//	public List<Employee> getAllProduct(){
//		return this.candidateService.getAllEmployees();
//	}
}
