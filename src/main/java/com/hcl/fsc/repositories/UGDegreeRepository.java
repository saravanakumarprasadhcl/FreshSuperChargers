package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.mastertables.UGDegree;

@Repository
public interface UGDegreeRepository extends JpaRepository<UGDegree, String> {
	
	public UGDegree getByKey(String key);
	public UGDegree findByValue(String value);
}
