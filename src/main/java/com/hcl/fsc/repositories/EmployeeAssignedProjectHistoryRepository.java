package com.hcl.fsc.repositories;

import com.hcl.fsc.entities.EmployeeAssignedProjectHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAssignedProjectHistoryRepository extends JpaRepository<EmployeeAssignedProjectHistory,Long> {

    @Query(value="Select * From employee_assigned_project_history Where employee_code=?", nativeQuery = true)
    public List<EmployeeAssignedProjectHistory> getEmployeeAssignedProjectHistoriesByECode(Long eCode);

}
