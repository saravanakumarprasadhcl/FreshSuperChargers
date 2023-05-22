package com.hcl.fsc.mastertables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Gender {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer uid;
	@Id
	private String genderKey;
	private String genderValue;
	

}
