package com.example.demo.Entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.mastercard.dxp.entity.User_credential;


@Entity
@Table(name = "Task")
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long taskId;
    
	/*@ManyToOne()
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    //private User_credential userCredential;*/
	
	@Column(name="userId")
	private long userId;
	
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "Status")
	private String Status;
	
	@Column(name = "duedate")
	private LocalDate duedate;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}
}
