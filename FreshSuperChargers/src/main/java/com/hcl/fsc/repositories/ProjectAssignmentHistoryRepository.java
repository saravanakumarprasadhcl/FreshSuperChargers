package com.hcl.fsc.repositories;

import com.hcl.fsc.entities.ProjectAssignmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectAssignmentHistoryRepository extends JpaRepository<com.hcl.fsc.entities.ProjectAssignmentHistory, Integer> {

    @Query(value = "Select * From Project_assignment_history Where employee_code=?", nativeQuery = true)
    public List<com.hcl.fsc.entities.ProjectAssignmentHistory> getEmployeeAssignedProjectHistoriesByECode(int eCode);

//    @Query(value = "select * from Project_assignment_history ORDER BY id limit ?,1",nativeQuery = true)
//    public ProjectAssignmentHistory getLatestRecored(int number);
    public ProjectAssignmentHistory findFirstByOrderByIdDesc();

}
