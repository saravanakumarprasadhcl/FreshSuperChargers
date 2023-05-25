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
	private Long id;
	private Long sapId;
	private String onboardingStatus;
	private String offeredDesignation;
	private String offeredBand; 
	private String offeredSubBand;
	private String collegeTiering ;
	private String fpm_spoc;
	private String location;
	private String internJoiningStatus;
	private String internJoiningDate;
	private String internSapID;
	private String br;
	private String h1_h2;
	private String preOTPStatus;
	private String tentativeJoiningMonth;
	private String requisitionSource;
	private String plannedDOJ;
	private String month;
	private String tentativeJoiningQTR;
	private String tentativeDOJ;
	private String joiningStatus;
	private String ownership;
	private String tPPanel;
	private String tPSap;


}
