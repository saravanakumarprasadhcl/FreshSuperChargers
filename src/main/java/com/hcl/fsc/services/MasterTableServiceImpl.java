package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;

@Service
public class MasterTableServiceImpl {
	
	@Autowired
    private GenderRepository genderRepository;
	
	@Autowired
    private RegionRepository regionRepository;
	
	@Autowired
    private StateRepository stateRepository;
    
	public List getAllMaster(String masterTable){
		switch(masterTable) {
		case "gender":
			return this.genderRepository.findAll();
		case "region":
			return this.regionRepository.findAll();
		case "state":
			return this.stateRepository.findAll();
		}
		return new ArrayList<>();
	}
	
	public Gender addGender(Gender gender) {
		return this.genderRepository.save(gender);
		
	}
	
//	public void deleteGender(String genderkey) {
//		Gender gender=this.genderRepository.getByGenderKey(genderkey);
//		this.genderRepository.delete(gender);
//	}
}
