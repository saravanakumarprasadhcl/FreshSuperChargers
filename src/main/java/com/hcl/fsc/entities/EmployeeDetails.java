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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeDetails {
   	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Long sapId;
	private String name;
	
	@OneToOne
	private Gender gender;
	
	private String email;
	private Long contactNo;
	private Long alternateContactNo;
	private String address;
	
	@OneToOne
	private State state;	
	
	@OneToOne
	private Region region;
	
	
}
