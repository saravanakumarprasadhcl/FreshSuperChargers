package com.hcl.fsc.entities;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "SAP_ID")
	private Long sapId;
	
	@Column(name = "StudentName")
	private String studentName;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Contact")
	private String contact;
	
	@Column(name = "AlternativeMobileNumber")
	private String alternateContactNo;
	
	@Column(name = "CompletePermanentAddress")
	private String address;
	
	@Column(name = "StateName")
	private String stateName;
	
	@Column(name = "Region")
	private String region;
	
}
