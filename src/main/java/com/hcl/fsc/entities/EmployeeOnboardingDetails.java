package com.hcl.fsc.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeOnboardingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "SAP_ID")
	private Long sapId;
	
	@Column(name = "OnboardingStatus")
	private String onboardingStatus;
	
	@Column(name = "DriveCollege")
	private String driveCollege;
	
	@Column(name="DriveDate")
//	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/mm/yyyy")
	private LocalDate driveDate;
	
	@Column(name = "OfferedDesignation")
	private String offeredDesignation;
	
	@Column(name = "OfferedBand")
	private String offeredBand;
	
	@Column(name = "OfferedSubBand")
	private String offeredSubBand;
	
	@Column(name = "CollegeTiering")
	private String collegeTiering ;
	
	@Column(name = "FPM_SPOC")
	private String fpm_spoc;
	
	@Column(name = "Location")
	private String location;
	
	@Column(name = "InternJoiningStatus")
	private String internJoiningStatus;
	
	@Column(name = "InternJoiningdate")
	private String internJoiningDate;
	
	@Column(name = "InternSAPID")
	private String internSapID;
	
	@Column(name = "BR")
	private String br;
	
	@Column(name = "H1_H2")
	private String h1_h2;
	
	@Column(name = "PreOTPStatus")
	private String preOTPStatus;
	
	@Column(name = "TentativeJoiningMonth")
	private String tentativeJoiningMonth;
	
	@Column(name = "Requisitionsource")
	private String requisitionSource;
	
	@Column(name = "PlannedDOJ")
	private String plannedDOJ;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "TentativeJoiningQTR")
	private String tentativeJoiningQTR;
	
	@Column(name = "TentativeDOJ")
	private String tentativeDOJ;
	
	@Column(name = "JoiningStatus")
	private String joiningStatus;
	
	@Column(name = "Ownership")
	private String ownership;
	
	@Column(name = "TPPanel")
	private String tPPanel;
	
	@Column(name = "TPSap")
	private String tPSap;
	
	@Column(name = "FinalStatus")
	private String finalStatus;
	
}
