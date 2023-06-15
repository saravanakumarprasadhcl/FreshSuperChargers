package com.hcl.fsc.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeAssignedProject")
public class EmployeeAssignedProject {
    @Id
    private Long employeeCode;


    private Long projectCode;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date startDate;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date endData;

    private String remarks;

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Long getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Long projectCode) {
        this.projectCode = projectCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<EmployeeAssignedProjectHistory> getEmployeeProjectAssignHistory() {
        return employeeProjectAssignHistory;
    }

    public void setEmployeeProjectAssignHistory(List<EmployeeAssignedProjectHistory> employeeProjectAssignHistory) {
        this.employeeProjectAssignHistory = employeeProjectAssignHistory;
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeAssignedProject")
    private List<EmployeeAssignedProjectHistory> employeeProjectAssignHistory;
}