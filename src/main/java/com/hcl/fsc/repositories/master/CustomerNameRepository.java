package com.hcl.fsc.repositories.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.CustomerName;

@Repository
public interface CustomerNameRepository extends JpaRepository<CustomerName, Integer> {

}

