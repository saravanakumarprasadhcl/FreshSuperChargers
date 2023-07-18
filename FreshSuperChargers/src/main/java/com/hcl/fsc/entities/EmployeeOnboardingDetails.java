package com.hcl.fsc.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.Location;
import com.hcl.fsc.mastertables.OfferedBand;
import com.hcl.fsc.mastertables.OfferedDesignation;
import com.hcl.fsc.mastertables.OfferedSubBand;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeeOnboardingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private Long sapId;
	private String onbaordingDetails;
	private String onboardingStatus;
	private String driveCollege;
	private String driveDate;
	//master table
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OfferedDesignation offeredDesignation;
	//master table
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private  OfferedBand offeredBand; 
	//master table
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private OfferedSubBand offeredSubBand;
	//master table
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CollegeTiering collegeTiering ;
	private String FPM_SPOC;
	//master table
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	private String getAssigned;
	//private Boolean getAssigned;
	//private String finalStatus;
	//private String ownership;
		
//	@Column(name="DriveDate")
//	@JsonFormat(pattern="dd-MM-yyyy")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "dd/mm/yyyy")
//	private LocalDate driveDate;
	


}