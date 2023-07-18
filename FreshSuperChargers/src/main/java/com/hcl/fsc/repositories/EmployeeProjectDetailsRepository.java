package com.hcl.fsc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.hcl.fsc.entities.EmployeeProjectDetails;


@Repository

public interface EmployeeProjectDetailsRepository extends JpaRepository<EmployeeProjectDetails, Integer> {

    public EmployeeProjectDetails findByEmpSAPID(int id);


}