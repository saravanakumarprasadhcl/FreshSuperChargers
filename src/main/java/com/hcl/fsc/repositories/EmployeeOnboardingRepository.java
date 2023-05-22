package com.hcl.fsc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.excel.vivo.EmployeeOnboardingDetails;

@Repository
public interface EmployeeOnboardingRepository extends JpaRepository<EmployeeOnboardingDetails, Integer>{

}
