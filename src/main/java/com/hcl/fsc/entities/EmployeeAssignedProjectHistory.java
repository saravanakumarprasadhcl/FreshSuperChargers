package com.hcl.fsc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeAssignedProjectHistory")
public class EmployeeAssignedProjectHistory {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;


    private Long projectCode;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date startDate;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date endData;


    private String remarks;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public EmployeeAssignedProject getEmployeeAssignedProject() {
        return employeeAssignedProject;
    }

    public void setEmployeeAssignedProject(EmployeeAssignedProject employeeAssignedProject) {
        this.employeeAssignedProject = employeeAssignedProject;
    }

    @ManyToOne
    @JoinColumn(name = "employee_code")
    @JsonBackReference
    private EmployeeAssignedProject employeeAssignedProject;
}
