package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.Lob;

@Repository
public interface LobRepository extends JpaRepository<Lob, String>{
	
	public Lob findByLOBKEY(String lobkey);

}
