package com.hcl.fsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fsc.mastertables.CustomerName;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.MasterTables;
import com.hcl.fsc.repositories.CollegeTieringRepository;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.GraduationSpecializationRepository;
import com.hcl.fsc.repositories.L1Repository;
import com.hcl.fsc.repositories.L2Repository;
import com.hcl.fsc.repositories.L3Repository;
import com.hcl.fsc.repositories.L4Repository;
import com.hcl.fsc.repositories.LobRepository;
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.OnboardingStatusRepository;
//import com.hcl.fsc.repositories.OnboardingStatusRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;
import com.hcl.fsc.repositories.UgDegreeRepository;
import com.hcl.fsc.services.MasterTableServiceImpl;
import com.hcl.fsc.services.master.MasterTableService;

@RestController
public class MasterTableController {


//	@Autowired
//	private MasterTableServiceImpl employeeService;

	@Autowired
	private GenderRepository genderrepository;

	@Autowired
	private LobRepository lobrepository;

	@Autowired
	private LocationRepository locationrepository;

	@Autowired
	private RegionRepository regionrepository;

	@Autowired
	private CollegeTieringRepository collegeTieringrepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private L1Repository l1Repository;

	@Autowired
	private L2Repository l2Repository;

	@Autowired
	private L3Repository l3Repository;

	@Autowired
	private L4Repository l4Repository;

	@Autowired
	private UgDegreeRepository ugDegreeRepository;

	@Autowired
	private UGOrPGRepository ugOrPgRepository;

	@Autowired
	private GraduationSpecializationRepository ugSpecializationRepository;

	@Autowired
	private OnboardingStatusRepository onboardingStatusRepository;

	@Autowired
	private OfferedBandRepository offeredBandRepository;

	@Autowired
	private OfferedSubBandRepository offeredSubBandRepository;

	@Autowired
	private OfferedDesignationRepository offeredDesignationRepository;

	@Autowired
	private MasterTableServiceImpl masterTableService;

//	@GetMapping("master/{masterTable}")
//	public List getMasterTableDetails(@PathVariable String masterTable) {
//		
//		return masterTableService.getAllMaster(masterTable.toLowerCase());
//		
//	}

//	@PostMapping("master/gender")
//	public Gender addGender(@RequestBody Gender gender) {
//		return this.masterTableService.addGender(gender);
//		
//	}

//	@DeleteMapping("master/gender/{genderKey}")
//	public String deleteGender(@PathVariable String genderkey) {
//		this.masterTableService.deleteGender(genderkey);
//		return "gender deleted";
//	}

//	@GetMapping("master/{mastertable}")
//	public List getTable(@PathVariable String mastertable) {
//
//		return employeeService.getRecord(mastertable);
//
//	}

//	@GetMapping("master/{mastertable}/{key}")
	// public List getRecordbyKey(@PathVariable String mastertable, @PathVariable
	// String key)
//	public ResponseEntity<?> getRecordbykey(@PathVariable String mastertable, @PathVariable String key) {
////		return employeeService.getRecordbyKey(mastertable,key);
//
//		return new ResponseEntity<>(employeeService.getRecordbyKey(mastertable, key), HttpStatus.OK);

//
//	@Autowired
//	private MasterTableServiceImpl masterTableService;
	
	@Autowired
	private MasterTableService masterTable;

	@GetMapping("master/{mastertable}")
	public List getTable(@PathVariable String mastertable) {
		return masterTableService.getRecord(mastertable);
	}

	@GetMapping("master/{mastertable}/{key}")
	public ResponseEntity<?> getRecordbykey(@PathVariable String mastertable, @PathVariable String key) {
		return new ResponseEntity<>(masterTableService.getRecordbyKey(mastertable, key), HttpStatus.OK);
	}


	@PostMapping("/master/{str}")
	public ResponseEntity<String> CreateRecord(@RequestBody MasterTables master, @PathVariable String str) {



		int res = masterTableService.createData(master, str);

		if (res == 1)
			return ResponseEntity.ok("Data saved successfully!");
		else
			return ResponseEntity.ok("KEY is null or empty");


	}

//	@PutMapping("master/{str}/{key}")
//	public ResponseEntity<String> updateRecord(@PathVariable String key, @PathVariable String str,
//			@RequestBody MasterTables master) {
//		// employeeService.updateRecord(key.toUpperCase(),master, str);
//
//		int res = employeeService.updateRecord(key, master, str);
//		if (res == 1)
//			return ResponseEntity.ok("Data Updated successfully!");
//		else
//			return ResponseEntity.ok("VALUE is null or empty");
//
//	}
//
//	@DeleteMapping("master/{str}/{key}")
//	public ResponseEntity<String> deleteRecord(@PathVariable String key, @PathVariable String str) {
//		employeeService.deleteRecord(key, str);
//		return ResponseEntity.ok("Data Deleted successfully!");
//	}

//	@DeleteMapping("master/gender/{genderkey}")
//	public void deleteMapping(@PathVariable String genderkey) {
//		employeeService.deleteGender(genderkey);
//	}


//	}

	@PutMapping("master/{str}/{key}")
	public ResponseEntity<String> updateRecord(@PathVariable String key, @PathVariable String str,
			@RequestBody MasterTables master) {
		int res = masterTableService.updateRecord(key, master, str);
		if (res == 1)
			return ResponseEntity.ok("Data Updated successfully!");
		else
			return ResponseEntity.ok("VALUE is null or empty");

	}

	@DeleteMapping("master/{str}/{key}")
	public ResponseEntity<String> deleteRecord(@PathVariable String key, @PathVariable String str) {
		masterTableService.deleteRecord(key, str);
		return ResponseEntity.ok("Data Deleted successfully!");
	}
	
	@GetMapping("master/customerName")
	public List<CustomerName> getAllCustomerName(){
		return this.masterTable.getAllCustomerName();
	}

}
