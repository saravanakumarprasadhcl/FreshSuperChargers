package com.hcl.fsc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "education_details")
public class EmployeeEducationalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="SAP_ID")
	private Long sapID;
	
	@Column(name="Batch")
	private String batch;
	
	@Column(name="10thPassingYear")
	private String passingYear10th;
	
	@Column(name="12thPercentage")
	private String percentage12th;
	
	@Column(name="12thPassingYear")
	private String passingYear12th;
	
	@Column(name="GraduationCollege")
	private String graduationCollege;
	
	@Column(name="UGDegree")
	private String ugDegree;
	
	@Column(name="GraduationSpecialization")
	private String ugSpecialization;
	
	@Column(name="GraduationPassingYear")
	private String graduationPassingYear;
	
	@Column(name="UniversityRegistrationId")
	private String universityRegistrationId;
	
	@Column(name="PostGraduationDegree")
	private String pgDegree;
	
	@Column(name="PostGraduationSpecialisation")
	private String pgSpecialization;
	
	@Column(name="PostGraduationPassingYear")
	private String postGraduationPassingYear;
	
	@Column(name="PostGraduationPercentage")
	private String postGraduationPercentage;
	
	@Column(name="PGCollegeName")
	private String pgCollegeName;
	
	@Column(name="UG_PG")
	private String UG_PG;
	
}
