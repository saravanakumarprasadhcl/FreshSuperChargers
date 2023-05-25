package com.hcl.fsc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="Candidates")
public class Employee {
   	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private Long sapId;
	private String name;
	private String gender;
	private String email;
	private Long contactNo;
	private Long alternateContactNo;
	private String address;
	private String state;
	private String region;
	
	
}
