package com.hcl.elch.freshersuperchargers.trainingworkflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="Modules")
public class Modules {
	
	@Id
	@Column(name="moduleId")
	long moduleId;
	
	@Column(name = "moduleName")
	private String moduleName;
	
	@Column(name="Exam")
	private String Exam;
	
	@Column(name="groupId")
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getExam() {
		return Exam;
	}

	public void setExam(String exam) {
		Exam = exam;
	}
}
