package com.hcl.fsc.entities;

import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.Region;
import com.hcl.fsc.mastertables.State;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long sapId;

	private String name;

	private String email;

	private String contact;

	private String alternateContactNo;

	private String address;

	@OneToOne
	private Gender gender;

	@OneToOne
	private State state;

	@OneToOne
	private Region region;

}
