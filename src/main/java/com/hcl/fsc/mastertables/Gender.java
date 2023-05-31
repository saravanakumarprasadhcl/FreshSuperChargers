package com.hcl.fsc.mastertables;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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

//	public Gender(String key, String value) {
//		this.GENDERKEY = key;
//		this.GENDERVALUE = value;
//	}

	@GenericGenerator(name = "wikiSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_gender_seq"),
			@Parameter(name = "initial_value", value = "4"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator")
			private Integer UID;
			@Id
			@Column(name="GENDERKEY")
			private String GENDERKEY;
			@Column(name="GENDERVALUE")
			private String GENDERVALUE;
}
