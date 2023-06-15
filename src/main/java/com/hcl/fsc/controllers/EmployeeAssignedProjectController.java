package com.hcl.fsc.controllers;

import com.hcl.fsc.entities.EmployeeAssignedProject;
import com.hcl.fsc.entities.EmployeeAssignedProjectHistory;
import com.hcl.fsc.repositories.EmployeeAssignedProjectHistoryRepository;
import com.hcl.fsc.repositories.EmployeeAssignedProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("*")
public class EmployeeAssignedProjectController {
    @Autowired
    private EmployeeAssignedProjectHistoryRepository employeeAssignedProjectHistoryRepository;

    @Autowired
    private EmployeeAssignedProjectRepository employeeAssignedProjectRepository;

    @PostMapping("/employee/assign/")
    public EmployeeAssignedProject employeeAssignedProject(@RequestBody EmployeeAssignedProject employeeAssigned) {

        if (employeeAssignedProjectRepository.findById(employeeAssigned.getEmployeeCode()).isEmpty()) {

            return employeeAssignedProjectRepository.save(employeeAssigned);
        } else {
            Date currentDate = new Date();
            EmployeeAssignedProjectHistory assignedProjectHistory = new EmployeeAssignedProjectHistory();
            EmployeeAssignedProject assignedProjectOld = employeeAssignedProjectRepository.getEmployeeAssignedProjectByEmployeeCode(employeeAssigned.getEmployeeCode());

            assignedProjectHistory.setProjectCode(assignedProjectOld.getProjectCode());
            assignedProjectHistory.setStartDate(assignedProjectOld.getStartDate());
            assignedProjectHistory.setEndData(assignedProjectOld.getEndData());
            assignedProjectHistory.setRemarks(assignedProjectOld.getRemarks());
            assignedProjectHistory.setModifiedDate(currentDate);

            assignedProjectHistory.setEmployeeAssignedProject(assignedProjectOld);

            List<EmployeeAssignedProjectHistory> listHistory = new ArrayList<>();
            listHistory.add(assignedProjectHistory);
            employeeAssignedProjectHistoryRepository.save(assignedProjectHistory);
            employeeAssigned.setEmployeeProjectAssignHistory(listHistory);
//            EmployeeAssignedProject display = employeeAssignedProjectRepository.getEmployeeAssignedProjectByEmployeeCode(employeeAssigned.getEmployeeCode());
//            System.out.println(display.getEmployeeProjectAssignHistory());


            return employeeAssignedProjectRepository.save(employeeAssigned);
        }


    }

    @GetMapping("/employee/assignedHistory/{employeeCode}")
    public List<EmployeeAssignedProjectHistory> employeeAssignedProjectHistoryList(@PathVariable Long employeeCode) {
        return employeeAssignedProjectHistoryRepository.getEmployeeAssignedProjectHistoriesByECode(employeeCode);
    }

}
