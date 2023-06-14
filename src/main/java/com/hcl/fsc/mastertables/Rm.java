package com.hcl.fsc.mastertables;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rm_master")
public class Rm {
	
	@Id
	private Integer uid;
	
	private String sapId;
	
	private String rmName;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
 }

