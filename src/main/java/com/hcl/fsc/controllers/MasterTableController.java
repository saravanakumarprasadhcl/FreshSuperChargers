package com.hcl.fsc.controllers;

import java.util.ArrayList;
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

import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.services.EmployeeServiceImpl;


@RestController
public class MasterTableController {
	 
	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("master/{mastertable}")
	public List getMasterTable(@PathVariable String mastertable) {
		//System.out.println(mastertable);
		switch(mastertable.toLowerCase()) {
		case "gender":
			return this.employeeService.getAllGender();			
		case "lob":
            return this.employeeService.getAllLob();
		} 
		return new ArrayList<>();
	}
	
	@GetMapping("master/{mastertable}/{key}")
	public ResponseEntity<Object> getbyGenderkey(@PathVariable String mastertable, @PathVariable String key) {
		switch(mastertable.toLowerCase()) {
		case "gender":
//			return ((Object) employeeService).getbyGenderkey(key);
			return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getbyGenderkey(key));
//	    return ResponseEntity.of(key);
		case "lob":
//			return ResponseEntity.status(HttpStatus.OK).body(this.(mastertable, key));
//            return this.employeeService.getAllLob();
		default:
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
		} 
		
}

	@PostMapping("master/gender")
	public Gender addGender(@RequestBody Gender gender) {
	    return employeeService.addGender(gender);

    }
	
	@PutMapping("master/gender/{genderkey}")
	public void updateGender(@PathVariable String genderkey ,@RequestBody Gender gender) {
		 employeeService.updateGender(genderkey,gender);
	}
	@DeleteMapping("master/gender/{genderkey}")
	public void deleteMapping(@PathVariable String genderkey) {
		employeeService.deleteGender(genderkey);
	}
	

}