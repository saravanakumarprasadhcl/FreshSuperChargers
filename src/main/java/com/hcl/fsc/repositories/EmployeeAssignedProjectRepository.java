package com.hcl.fsc.repositories;

import com.hcl.fsc.entities.EmployeeAssignedProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeAssignedProjectRepository extends JpaRepository<EmployeeAssignedProject, Long> {

    @Query(value = "Select * from employee_assigned_project Where employee_code=?", nativeQuery = true)
    public EmployeeAssignedProject getEmployeeAssignedProjectByEmployeeCode(Long eCode);
}
