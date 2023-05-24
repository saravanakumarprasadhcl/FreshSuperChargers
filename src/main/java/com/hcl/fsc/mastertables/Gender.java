package com.hcl.fsc.mastertables;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(name="GENDER_SEQUENCE_GENERATOR", sequenceName="GENDER_SEQUENCE", initialValue=521, allocationSize=1)
@Table(name = "Master_Gender")
public class Gender {

	@GenericGenerator(name = "wikiSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_gender_seq"),
			@Parameter(name = "initial_value", value = "4"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator")
			private Integer UID;
			@Id
			private String GENDERKEY;
			private String GENDERVALUE;
//	   @GenericGenerator(
//		        name = "wikiSequenceGenerator",
//		        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//		        parameters = {
//		                @Parameter(name = "sequence_name", value = "WIKI_SEQUENCE"),
//		                @Parameter(name = "initial_value", value = "1000"),
//		                @Parameter(name = "increment_size", value = "1")
//		        }
//		)
//		

//    List<Gender> genderList;
//    Map<String,String> genderMap;

}
