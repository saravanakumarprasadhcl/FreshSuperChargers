package com.hcl.fsc.mastertables;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_code_master")
public class ProjectCode {

	@Id
	private Integer uid;

	private String projectCode;

	private String projectName;

	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;


}
