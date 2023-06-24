package com.hcl.elch.freshersuperchargers.trainingworkflowproducer.entity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long taskId;

    @Column(name="userId")
    private long userId;


    @Column(name = "task")
    private String task;

    @Column(name = "Status")
    private String Status;

    @Column(name = "duedate")
    private LocalDate duedate;
    
    @Column(name="approver")
    private String approver;

}