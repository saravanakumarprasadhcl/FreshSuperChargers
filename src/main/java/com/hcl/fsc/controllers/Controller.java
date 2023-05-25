package com.hcl.fsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.helpers.Helper;
import com.hcl.fsc.services.MoUService;
import com.hcl.fsc.services.SkilledHiringService;
import com.hcl.fsc.services.Tier_1Service;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	private Tier_1Service tier_1Service;

	@Autowired
	private SkilledHiringService skilledHiringService;

	@Autowired
	private MoUService mouService;

	@PostMapping("fsc/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if (Helper.checkExcelFormate(file)) {
			this.tier_1Service.save(file);
			this.skilledHiringService.save(file);
			this.mouService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Upload");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel sheet Only");
	}

}
