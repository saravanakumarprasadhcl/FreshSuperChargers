package com.hcl.fsc.mastertables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name="GENDER_SEQUENCE_GENERATOR", sequenceName="GENDER_SEQUENCE", initialValue=100, allocationSize=1)
public class Gender {
	
	@Id
	//generated on the database type
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENDER_SEQUENCE_GENERATOR")
	private Integer UID;
	private String GENDERKEY;
	private String GENDERVALUE;

//    List<Gender> genderList;
//    Map<String,String> genderMap;

}

