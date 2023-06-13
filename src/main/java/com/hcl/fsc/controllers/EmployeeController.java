package com.hcl.fsc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.hcl.fsc.helpers.ResponseList;
import com.hcl.fsc.services.EmployeeCDACServiceImpl;
import com.hcl.fsc.services.EmployeeDigiBeeServiceImpl;
import com.hcl.fsc.services.EmployeeMoUService;
import com.hcl.fsc.services.EmployeeNonTier1ServiceImpl;
//import com.hcl.fsc.services.MasterTableServiceImpl;
import com.hcl.fsc.services.EmployeeSkilledHiringService;
import com.hcl.fsc.services.EmployeeTier1Service;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeNonTier1ServiceImpl employeeNonTier1Service;

	@Autowired
	private EmployeeCDACServiceImpl employeeCDACService;

	@Autowired
	private EmployeeDigiBeeServiceImpl employeeDigiBeeService;

	@Autowired
	private EmployeeTier1Service employeeTier1Service;

	@Autowired
	private EmployeeSkilledHiringService employeeSkilledHiringService;

	@Autowired
	private EmployeeMoUService employeeMoUService;

	@PostMapping("fsc/upload")
	public ResponseEntity<?> employeeNonTier1Uplaod(@RequestParam("file") MultipartFile[] file) {
		int count = 0;
		ResponseList responseList = new ResponseList();
		for (int i = 0; i < file.length; i++) {

			if (EmployeeHelper.checkExcelFormate(file[i])) {
				responseList = new ResponseList();
				ResponseList responseList1 = this.employeeNonTier1Service.employeeNonTier1ListSave(file[i]);
				ResponseList responseList2 = (this.employeeDigiBeeService.employeeDigiBeeListSave(file[i]));
				ResponseList responseList3 = (this.employeeCDACService.employeeCDACListSave(file[i]));
				ResponseList responseList4 = this.employeeTier1Service.employeeTier1ListSave(file[i]);
				ResponseList responseList5 = this.employeeSkilledHiringService.employeeSkilledHiringListSave(file[i]);
				ResponseList responseList6 = this.employeeMoUService.employeeMoUListSave(file[i]);

				responseList
						.setTotal_No_Records(responseList1.getTotal_No_Records() + responseList2.getTotal_No_Records()
								+ responseList3.getTotal_No_Records() + responseList4.getTotal_No_Records()
								+ responseList5.getTotal_No_Records() + responseList6.getTotal_No_Records());

				responseList.setSucessful_Records(
						responseList1.getSucessful_Records() + responseList2.getSucessful_Records()
								+ responseList3.getSucessful_Records() + responseList4.getSucessful_Records()
								+ responseList5.getSucessful_Records() + responseList6.getSucessful_Records());

				responseList.setFailed_Records(responseList1.getFailed_Records() + responseList2.getFailed_Records()
						+ responseList3.getFailed_Records() + responseList4.getFailed_Records()
						+ responseList5.getFailed_Records() + responseList6.getFailed_Records());

				responseList.setDuplicate_Records(
						responseList1.getDuplicate_Records() + responseList2.getDuplicate_Records()
								+ responseList3.getDuplicate_Records() + responseList4.getDuplicate_Records()
								+ responseList5.getDuplicate_Records() + responseList6.getDuplicate_Records());

				List<String> duplicate_Sap_List = new ArrayList<>();
				
				duplicate_Sap_List.addAll(responseList1.getDuplicate_Sap_List());
				duplicate_Sap_List.addAll(responseList2.getDuplicate_Sap_List());
				duplicate_Sap_List.addAll(responseList3.getDuplicate_Sap_List());
				duplicate_Sap_List.addAll(responseList4.getDuplicate_Sap_List());
				duplicate_Sap_List.addAll(responseList5.getDuplicate_Sap_List());
				duplicate_Sap_List.addAll(responseList6.getDuplicate_Sap_List());
				responseList.setDuplicate_Sap_List(duplicate_Sap_List);

				Map<String, List<String>> failed_Record_List = new HashMap<>();
				failed_Record_List.putAll(responseList1.getFailed_Records_List());
				failed_Record_List.putAll(responseList2.getFailed_Records_List());
				failed_Record_List.putAll(responseList3.getFailed_Records_List());
				failed_Record_List.putAll(responseList4.getFailed_Records_List());
				failed_Record_List.putAll(responseList5.getFailed_Records_List());
				failed_Record_List.putAll(responseList6.getFailed_Records_List());
				responseList.setFailed_Records_List(failed_Record_List);

				count++;
			} else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");
		}
		if (count == file.length) {
			return ResponseEntity.status(HttpStatus.OK).body(responseList);
		} else
			return ResponseEntity
					.ok(Map.of("message", file.length - count + "File is not uploaded maybe some values are null"));

	}

	@GetMapping("/employeesList")
	public List<EmployeeDetails> getAllEmployeesDetails() {
		return this.employeeNonTier1Service.getAllEmployees();
	}

}
