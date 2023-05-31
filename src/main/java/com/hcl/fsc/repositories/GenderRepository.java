package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.Lob;


public interface GenderRepository extends JpaRepository<Gender, String>{
	
//	public Gender findByGENDERKEY(String genderkey);

	

}
