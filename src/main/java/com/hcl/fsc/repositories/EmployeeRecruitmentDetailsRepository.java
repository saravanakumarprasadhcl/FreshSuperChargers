package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.excel.vivo.EmployeeRecruitmentDetails;

@Repository
public interface EmployeeRecruitmentDetailsRepository extends JpaRepository<EmployeeRecruitmentDetails, Integer>{

}
