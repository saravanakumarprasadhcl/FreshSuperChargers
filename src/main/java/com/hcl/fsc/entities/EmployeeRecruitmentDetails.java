package com.hcl.fsc.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
public class EmployeeRecruitmentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
//	private Long sapId;
	
	@Column(name="ProjectSKills")
	private String projectSkills;
	
	@Column(name="LOB")
	private String lob;
	
	@Column(name="Team_RDU")
	private String team_RDU;
	
	@Column(name="HRPanel")
	private String hRPanel;
	
	@Column(name="L1")
	private String L1;
	
	@Column(name="L2")
	private String L2;
	
	@Column(name="L3")
	private String L3;
	
	@Column(name="L4")
	private String L4;
	
	@Column(name="DemandOwner")
	private String demandOwner;
	
	@Column(name="DemandOwnerSAP")
	private String demandOwnerSAP;
	
	@Column(name="CandidateMapping")
	private String candidateMapping;
	
	@Column(name="BS")
	private String bs;
	
	@Column(name ="Dummy_Original")
	private String dummy_Original;
	
	@Column(name="SRMapping")
	private String srMapping;
	
	@Column(name="SRstatus")
	private String srStatus;
	
	@Column(name="CurrentBatchCode")
	private String currentBatchCode;
	
	@Column(name="RequiredBatchCode")
	private String requiredBatchCode;
	
	@Column(name="RemappedProfile")
	private String remappedProfile;
	
	@Column(name="Remappedlocation")
	private String remappedLocation;
	
	@Column(name = "Acknowledgment")
	private String acknowledgment;
	
	@Column(name="FinAMStatus")
	private String finAMStatus;
	
	@Column(name="SRNumber")
	private String srNumber;

}
