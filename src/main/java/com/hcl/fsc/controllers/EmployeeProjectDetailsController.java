package com.hcl.fsc.controllers;

import com.hcl.fsc.entities.EmployeeProjectDetails;
import com.hcl.fsc.entities.ProjectAssignmentHistory;
import com.hcl.fsc.repositories.EmployeeProjectDetailsRepository;
import com.hcl.fsc.repositories.ProjectAssignmentHistoryRepository;
import com.hcl.fsc.services.EmployeeProjectDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeProjectDetailsController {


    @Autowired
    private EmployeeProjectDetailsRepository employeeProjectDetailsRepository;


    @Autowired
    private EmployeeProjectDetailsService employeeProjectDetailsService;

    @Autowired
    private ProjectAssignmentHistoryRepository projectAssignmentHistory;


    @PostMapping("/project")
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeProjectDetails employeeProjectDetails) {

//        try {
//
//            return ResponseEntity.status(HttpStatus.OK).body(this.employeeProjectDetailsService.add(employeeProjectDetails));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Value is null");
//        }
        if (employeeProjectDetailsRepository.findById(employeeProjectDetails.getEmpSAPID()).isEmpty()) {

            employeeProjectDetailsService.add(employeeProjectDetails);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Records Inserted Successfully");
        } else {
            LocalDate currentDate = LocalDate.now();
            ProjectAssignmentHistory projectAssignmentHistory = new ProjectAssignmentHistory();
            EmployeeProjectDetails assignedDetailsOld = employeeProjectDetailsRepository.getById(employeeProjectDetails.getEmpSAPID());
            projectAssignmentHistory.setProject_code(assignedDetailsOld.getProjID());
            projectAssignmentHistory.setAssignment_start_date(assignedDetailsOld.getAssignmentStartDate());
            projectAssignmentHistory.setAssignement_end_date(assignedDetailsOld.getAssignmentEndDate());
            projectAssignmentHistory.setRemarks(assignedDetailsOld.getRemarks());
            projectAssignmentHistory.setModified_date(currentDate);

            projectAssignmentHistory.setEmployeeProjectDetails(assignedDetailsOld);

            List<ProjectAssignmentHistory> listHistory = new ArrayList<>();
            listHistory.add(projectAssignmentHistory);
            //employeeProjectDetailsService.add(projectAssignmentHistory);
            employeeProjectDetails.setProjectAssignmentHistory(listHistory);
// employeeDetailsProject display = employeeDetailsProjectRepository.getemployeeDetailsProjectByEmployeeCode(employeeDetails.getEmpSAPID());
// System.out.println(display.getEmployeeProjectAssignHistory());


            employeeProjectDetailsService.add(employeeProjectDetails);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Records Inserted Successfully");
        }


    }

}
