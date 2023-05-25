package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.entities.EmployeeEducationDetails;



@Repository
public interface EmployeeEducationDetailsRepository extends JpaRepository<EmployeeEducationDetails, Long>{

}
