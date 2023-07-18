package com.hcl.fsc.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Employee_Project_Details")
public class EmployeeProjectDetails {


    @Id
    private Integer empSAPID;

    @NotNull(message = "Name may not be null")
    private Integer reportingMgrSAPID;

    @NotNull(message = "HRL4ID is mandatory")
    private Integer hrL4ID;

    @NotNull(message = "projID is mandatory")
    private Integer projID;

    private String lastProjectName;

    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;

    private LocalDate assignmentStartDate;

    private LocalDate assignmentEndDate;

    @NotBlank(message = "RASStatus is mandatory")
    private String rasStatus;

    @NotBlank(message = "Fresher is mandatory")
    private String fresher;

    @NotBlank(message = "On/Offshore is mandatory")
    private String onOff;

    @NotBlank(message = "Valid Designation is required")
    private String job;

    @NotBlank(message = "Skill is mandatory")
    private String skill;

    @NotNull(message = "fte required")
    private Integer fte;

    @NotNull(message = "SR required")
    private String SR;

    @NotBlank(message = "Name is mandatory")
    private String createdBy;

    private LocalDate createdDate;

    @NotBlank(message = "Name is mandatory")
    private String updatedBy;

    private LocalDate updatedDate;

    private String Remarks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeProjectDetails")
    @JsonManagedReference
    private List<ProjectAssignmentHistory> projectAssignmentHistory;


}