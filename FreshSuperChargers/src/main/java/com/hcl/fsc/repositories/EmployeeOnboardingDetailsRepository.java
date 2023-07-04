package com.hcl.fsc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.entities.EmployeeOnboardingDetails;

import java.util.List;

@Repository
public interface EmployeeOnboardingDetailsRepository extends JpaRepository<EmployeeOnboardingDetails, Long> {

    @Query(value = "select e.*,l.* from employee_onboarding_details e,master_location l where e.location_key=? AND e.location_key=l.KEY AND e.get_assigned=?", nativeQuery = true)
    public List<EmployeeOnboardingDetails> getEmployeeOnboardingDetailsByLocation(String location,String getAssigned);

    @Query(value = "select  e.*,ct.* from employee_onboarding_details e,master_college_tiering ct where e.college_tiering_key=? && e.college_tiering_key=ct.KEY AND e.get_assigned=?", nativeQuery = true)
    public List<EmployeeOnboardingDetails> getEmployeeOnboardingDetailsByCollegeTiering(String ct,String getAssigned);

    String queryUg = "SELECT e.*, edu.sap_id as edu_sap_id,edu.graduation_specialization_key, ug.* " +
            "FROM employee_onboarding_details e " +
            "JOIN employee_educational_details edu ON e.sap_id = edu.sap_id " +
            "JOIN master_ug_specialization ug ON edu.graduation_specialization_key = ug.KEY " +
            "WHERE edu.graduation_specialization_key = ? AND e.get_assigned=?";

    @Query(value = queryUg, nativeQuery = true)
    public List<EmployeeOnboardingDetails> getEmployeeOnboardingDetailsByUg(String ug,String getAssigned);

    @Query(value = "SELECT e.* from employee_onboarding_details e WHERE e.get_assigned=?",nativeQuery = true)
    public List<EmployeeOnboardingDetails> getAllEmployees(String getAssigned);


}
