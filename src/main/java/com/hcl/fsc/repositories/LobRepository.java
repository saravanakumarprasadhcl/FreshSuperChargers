package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.mastertables.LOB;

@Repository
public interface LOBRepository extends JpaRepository<LOB, String> {

	public LOB getByKey(String key);
	public LOB findByValue(String value);

}
