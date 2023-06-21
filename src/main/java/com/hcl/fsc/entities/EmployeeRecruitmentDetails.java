package com.hcl.fsc.entities;


import com.hcl.fsc.mastertables.L1;
import com.hcl.fsc.mastertables.L2;
import com.hcl.fsc.mastertables.L3;
import com.hcl.fsc.mastertables.L4;
import com.hcl.fsc.mastertables.LOB;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeeRecruitmentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Long sapId;
	private String projectSkills;
	//master table
	@OneToOne
	private LOB lob;
	private String team_Rdu;
	private String hrPanel;
	//master table
	@OneToOne
	private L1 l1;
	//master table
	@OneToOne
	private L2 l2;
	//master table
	@OneToOne
	private L3 l3;
	//master table
	@OneToOne
	private L4 l4;
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
