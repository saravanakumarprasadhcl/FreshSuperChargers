package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
