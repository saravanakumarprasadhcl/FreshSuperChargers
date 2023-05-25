package com.hcl.fsc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class EmployeeRecruitmentDetails {
	
	@Id
	private Long id;
	private Long sapId;
	private String projectSkills;
	private String lob;
	private String team_Rdu;
	private String hrPanel;
	private String L1;
	private String L2;
	private String L3;
	private String L4;
	private String demandOwner;
	private String demandOwnerSAP;
	private String candidateMapping;
	private String srMapping;
	private String srStatus; 
	private String remappedProfile;
	private String remappedLocation;
	private String srNumber;
	private String remarks;
	
}
