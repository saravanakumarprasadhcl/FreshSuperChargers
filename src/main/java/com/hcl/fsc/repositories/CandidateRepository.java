package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.entities.Candidate;



@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
}
