package com.hcl.fsc.entities;

import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.Location;
import com.hcl.fsc.mastertables.OfferedBand;
import com.hcl.fsc.mastertables.OfferedDesignation;
import com.hcl.fsc.mastertables.OfferedSubBand;

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
	private Long sapId;
	private String onbaordingDetails;
	private String onboardingStatus;
	private String driveCollege;
	private String driveDate;
	//master table
	@OneToOne
	private OfferedDesignation offeredDesignation;
	//master table
	@OneToOne
	private  OfferedBand offeredBand; 
	//master table
	@OneToOne
	private OfferedSubBand offeredSubBand;
	//master table
	@OneToOne
	private CollegeTiering collegeTiering ;
	private String FPM_SPOC;
	//master table
	@OneToOne
	private Location location;
	private String internJoiningStatus;
	private String internJoiningDate;
	private String internSapID;
	private String BR;
	private String h1OrH2;
	private String preOTPStatus;
	private String tentativeJoiningMonth;
	private String requisitionSource;
	private String plannedDOJ;
	private String month;
	private String tentativeJoiningQTR;
	private String tentativeDOJ;
	private String joiningStatus;
	private String tpPanel;
	private String tpSap;
	//private String finalStatus;
	//private String ownership;




}
