package com.hcl.fsc.mastertables;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="project_l4_master")
public class ProjectL4 {
	
	@Id
	private Integer uid;
	
	@Column(name="project_l4_code")
	private String projectL4Code;
	
	@Column(name="Project_l4_name")
	private String projectL4Name;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
}
