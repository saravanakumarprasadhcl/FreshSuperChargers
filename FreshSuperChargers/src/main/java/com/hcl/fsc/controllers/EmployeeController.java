package com.hcl.fsc.controllers;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EmployeeOnboardingDetailsRepository employeeOnboardingDetailsRepository;

    @PostMapping("fsc/upload")

    public ResponseEntity<?> employeeNonTier1Uplaod(@RequestParam("file") MultipartFile[] file) {

        int count = 0;

        List<String> errorsList = new ArrayList<>();

        for (int i = 0; i < file.length; i++) {

            if (EmployeeHelper.checkExcelFormate(file[i])) {

                errorsList.addAll(this.employeeNonTier1Service.employeeNonTier1ListSave(file[i]));

                errorsList.addAll(this.employeeDigiBeeService.employeeDigiBeeListSave(file[i]));

                errorsList.addAll(this.employeeCDACService.employeeCDACListSave(file[i]));

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


    @GetMapping("/employees/{keyword}/{value}")
    public List<EmployeeOnboardingDetails> getAllEmployeeWithFilter(@PathVariable String keyword, @PathVariable String value,@RequestParam("getassigned") String getAssigned) {


        if (keyword.equals("location")) {
            return employeeOnboardingDetailsRepository.getEmployeeOnboardingDetailsByLocation(value,getAssigned);
        } else if (keyword.equals("collegeTier")) {
            return employeeOnboardingDetailsRepository.getEmployeeOnboardingDetailsByCollegeTiering(value,getAssigned);
        } else if (keyword.equals("graduation")) {
            return employeeOnboardingDetailsRepository.getEmployeeOnboardingDetailsByUg(value,getAssigned);
        } else return employeeOnboardingDetailsRepository.getAllEmployees(getAssigned);
    }

//	else if(res==-1) { 

//		    int count=this.productService.getStatus(); 

//			return ResponseEntity.ok(Map.of("message", "File is uploaded partially "+count+" row in excel sheet have some improper data"));


}