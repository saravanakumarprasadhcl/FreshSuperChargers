package com.hcl.fsc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.services.MasterTableServiceImpl;

@RestController
public class MasterTableController {
	
	@Autowired
	private MasterTableServiceImpl masterTableService;
	
	@GetMapping("master/{masterTable}")
	public List getMasterTableDetails(@PathVariable String masterTable) {
		
		return masterTableService.getAllMaster(masterTable.toLowerCase());
		
	}
	
	@PostMapping("master/gender")
	public Gender addGender(@RequestBody Gender gender) {
		return this.masterTableService.addGender(gender);
		
	}
	
//	@DeleteMapping("master/gender/{genderKey}")
//	public String deleteGender(@PathVariable String genderkey) {
//		this.masterTableService.deleteGender(genderkey);
//		return "gender deleted";
//	}

}
