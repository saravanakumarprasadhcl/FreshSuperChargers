package com.hcl.fsc.entities;

import jakarta.persistence.*;
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
public class EmployeeOnboardingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer sapId;
	private String onbaordingDetails;
	private String onboardingStatus;
	private String driveCollege;
	private String driveDate;
	private String offeredDesignation;
	private String offeredBand; 
	private String offeredSubBand;
	private String collegeTiering ;
	private String FPM_SPOC;
	private String location;
	private String internJoiningStatus;
	private String internJoiningDate;
	private String internSapID;
	private String BR;
	private String H1OrH2;
	private String preOTPStatus;
	private String tentativeJoiningMonth;
	private String requisitionSource;
	private String plannedDOJ;
	private String month;
	private String tentativeJoiningQTR;
	private String tentativeDOJ;
	private String joiningStatus;




}
