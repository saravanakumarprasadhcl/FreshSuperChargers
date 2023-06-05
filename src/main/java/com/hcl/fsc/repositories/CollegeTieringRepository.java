package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.Gender;

@Repository
public interface CollegeTieringRepository extends JpaRepository<CollegeTiering,String> {
	
	public CollegeTiering getByKey(String key);
	public CollegeTiering findByValue(String value);
	
}
