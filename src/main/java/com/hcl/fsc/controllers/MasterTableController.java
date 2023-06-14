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

import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.CustomerName;
import com.hcl.fsc.mastertables.HrL4;
import com.hcl.fsc.mastertables.MasterTables;
import com.hcl.fsc.mastertables.ProjectCategory;
import com.hcl.fsc.mastertables.ProjectCode;
import com.hcl.fsc.mastertables.ProjectL4;
import com.hcl.fsc.mastertables.Rm;
import com.hcl.fsc.services.MasterTableServiceImpl;
import com.hcl.fsc.services.master.CustomerNameService;
import com.hcl.fsc.services.master.HrL4Service;
import com.hcl.fsc.services.master.ProjectCategoryService;
import com.hcl.fsc.services.master.ProjectCodeService;
import com.hcl.fsc.services.master.ProjectL4Service;
import com.hcl.fsc.services.master.RmService;

@RestController
public class MasterTableController {

	@Autowired
	private MasterTableServiceImpl masterTableService;

	@Autowired
	private CustomerNameService customerNameService;

	@Autowired
	private HrL4Service hrL4Service;

	@Autowired
	private ProjectCategoryService projectCategoryService;

	@Autowired
	private ProjectCodeService projectCodeService;

	@Autowired
	private ProjectL4Service projectL4Service;

	@Autowired
	private RmService rmService;

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

//	-----------------------------Get Mapping --------------------------------------------

	@GetMapping("master/projectCode")
	public List<ProjectCode> getAllProjectCode() {
		return this.projectCodeService.getAllProjectCode();
	}

	@GetMapping("master/hrl4")
	public List<HrL4> getAllHrL4() {
		return this.hrL4Service.getAllHrL4();
	}

	@GetMapping("master/projectL4")
	public List<ProjectL4> getAllProjectL4() {
		return this.projectL4Service.getAllProjectL4();
	}

	@GetMapping("master/rm")
	public List<Rm> getAllRM() {
		return this.rmService.getAllRM();
	}

	@GetMapping("master/customerName")
	public List<CustomerName> getAllCustomerName() {
		return this.customerNameService.getAllCustomerName();
	}

	@GetMapping("master/projectCategory")
	public List<ProjectCategory> getAllProjectCategory() {
		return this.projectCategoryService.getAllProjectCategory();
	}

//	-----------------------------Get Mapping By Id--------------------------------------------

	@GetMapping("master/projectCode/{uid}")
	public ResponseEntity<?> getProjectCodeById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectCodeService.getProjectCodeById(uid));
	}

	@GetMapping("master/hrl4/{uid}")
	public ResponseEntity<?> getHrL4ById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.hrL4Service.getHrL4ById(uid));
	}

	@GetMapping("master/projectL4/{uid}")
	public ResponseEntity<?> getProjectL4ById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectL4Service.getProjectL4ById(uid));
	}

	@GetMapping("master/rm/{uid}")
	public ResponseEntity<?> getRMById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.rmService.getRmById(uid));
	}

	@GetMapping("master/customerName/{uid}")
	public ResponseEntity<?> CustomerNameById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.customerNameService.getCustomerById(uid));
	}

	@GetMapping("master/projectCategory/{uid}")
	public ResponseEntity<?> getProjectCategoryById(@PathVariable Integer uid) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectCategoryService.getProjectCategoryById(uid));
	}

//	------------------------------Post Mapping--------------------------------------------------------
	@PostMapping("master/projectcode")
	public ResponseEntity<?> createProjectCode(@RequestBody ProjectCode projectcode) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectCodeService.createNewProjectCode(projectcode));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PostMapping("master/hrl4")
	public ResponseEntity<?> createHrL4(@RequestBody HrL4 hrL4) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.hrL4Service.createNewHrL4(hrL4));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	
	@PostMapping("master/projectL4")
	public ResponseEntity<?> createProjectL4(@RequestBody ProjectL4 projectL4) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectL4Service.createNewProjectL4(projectL4));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}

	@PostMapping("master/rm")
	public ResponseEntity<?> createRm(@RequestBody Rm rm) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.rmService.createNewRm(rm));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}

	@PostMapping("master/customername")
	public ResponseEntity<?> createCustomerName(@RequestBody CustomerName customerName) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.customerNameService.createNewCustomerName(customerName));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PostMapping("master/projectcategory")
	public ResponseEntity<?> createProjectCategory(@RequestBody ProjectCategory projectCategory) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectCategoryService.createNewProjectCategory(projectCategory));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
//	----------------------------- Put Mapping --------------------------------------------------------
	@PutMapping("master/projectCode/{uid}")
	public ResponseEntity<?> updateProjectCode(@RequestBody ProjectCode projectcode, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.projectCodeService.updateProjectCode(projectcode, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PutMapping("master/projectL4/{uid}")
	public ResponseEntity<?> updateProjectL4(@RequestBody ProjectL4 projectL4, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.projectL4Service.updateProjectL4(projectL4, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PutMapping("master/hrl4/{uid}")
	public ResponseEntity<?> updateHrL4(@RequestBody HrL4 hrl4, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.hrL4Service.updateHrL4(hrl4, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PutMapping("master/rm/{uid}")
	public ResponseEntity<?> updateRm(@RequestBody Rm rm, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.rmService.updateRm(rm, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PutMapping("master/customername/{uid}")
	public ResponseEntity<?> updateCustomerName(@RequestBody CustomerName customer, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.customerNameService.updateCustomerName(customer, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@PutMapping("master/projectcategory/{uid}")
	public ResponseEntity<?> updateProjectCategory(@RequestBody ProjectCategory projectCategory, @PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(this.projectCategoryService.updateProjectCategory(projectCategory, uid));
		} catch (NullValueException nullValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(nullValueException.getMessage()));
		} catch (DuplicateValueException duplicateValueException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(duplicateValueException.getMessage()));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}

//	-------------------------------- Delete Mapping -------------------------------------------------

	@DeleteMapping("master/projectCode/{uid}")
	public ResponseEntity<?> deleteProjectCode(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectCodeService.deleteProjectCodeById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}

	@DeleteMapping("master/hrl4/{uid}")
	public ResponseEntity<?> deleteHrl4ById(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.hrL4Service.deleteHrL4ById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@DeleteMapping("master/projectL4/{uid}")
	public ResponseEntity<?> deleteProjectL4(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectL4Service.deleteProjectL4ById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@DeleteMapping("master/rm/{uid}")
	public ResponseEntity<?> deleteRmById(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.rmService.deleteRmById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@DeleteMapping("master/customername/{uid}")
	public ResponseEntity<?> deleteCustomerNameById(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.customerNameService.deleteCustomerNameById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}
	
	@DeleteMapping("master/projectcategory/{uid}")
	public ResponseEntity<?> deleteProjectCategoryById(@PathVariable Integer uid) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.projectCategoryService.deleteProjectCategoryById(uid));
		} catch (ValueNotPresentException valueNotPresentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response(valueNotPresentException.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage()));
		}
	}

}
