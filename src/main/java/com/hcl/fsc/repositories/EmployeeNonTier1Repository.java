package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.entities.NonTier_1;


@Repository
public interface EmployeeNonTier1Repository extends JpaRepository<NonTier_1, Integer>{

}
