package com.hcl.fsc.controllers;

import java.util.ArrayList;
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

import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.services.EmployeeCDACServiceImpl;
import com.hcl.fsc.services.EmployeeDigiBeeServiceImpl;
import com.hcl.fsc.services.EmployeeNonTier1ServiceImpl;

//import com.hcl.fsc.services.MasterTableServiceImpl;

@RestController

public class EmployeeController {

	@Autowired

	private EmployeeNonTier1ServiceImpl employeeNonTier1Service;

	@Autowired

	private EmployeeCDACServiceImpl employeeCDACService;

	@Autowired

	private EmployeeDigiBeeServiceImpl employeeDigiBeeService;

	@PostMapping("fsc/upload")

	public ResponseEntity<?> employeeNonTier1Uplaod(@RequestParam("file") MultipartFile[] file) {

		int count = 0;

		List<String> errorsList = new ArrayList<>();

		for (MultipartFile element : file) {

			if (EmployeeHelper.checkExcelFormate(element)) {

				errorsList.addAll(this.employeeNonTier1Service.employeeNonTier1ListSave(element));

				errorsList.addAll(this.employeeDigiBeeService.employeeDigiBeeListSave(element));

				errorsList.addAll(this.employeeCDACService.employeeCDACListSave(element));

				count++;

			} else

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");

		}

		if (count == file.length) {

			if (errorsList.size() == 0)

				return ResponseEntity.ok(Map.of("message", "All files are uploaded"));

			else {

				errorsList.add(0, "All files are uploaded partially, all the errors are listed below :");

				errorsList.add("Total count of errors is " + (errorsList.size() - 1));

				return ResponseEntity.status(HttpStatus.OK).body(errorsList);

			}

		} else

			return ResponseEntity

					.ok(Map.of("message", file.length - count + "File is not uploaded maybe some values are null"));

	}

	@GetMapping("/employeesList")

	public List<EmployeeDetails> getAllEmployeesDetails() {

		return this.employeeNonTier1Service.getAllEmployees();

	}

//	else if(res==-1) {

//		    int count=this.productService.getStatus();

//			return ResponseEntity.ok(Map.of("message", "File is uploaded partially "+count+" row in excel sheet have some improper data"));

//	}

}