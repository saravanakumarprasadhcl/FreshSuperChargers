package com.hcl.fsc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Project_assignment_history")
public class ProjectAssignmentHistory {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    @NotNull(message = "Project Code may not be null")
    private int project_code;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignment_start_date;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignement_end_date;


    private String remarks;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate modified_date;

    private String skill;


    @ManyToOne
    @JoinColumn(name = "employee_code")
    @JsonBackReference
    private EmployeeProjectDetails employeeProjectDetails;
}
