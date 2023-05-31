package com.hcl.fsc.mastertables;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
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
@Table(name = "Master_Ug_Specialization")
public class UgSpecialization {
	
	@GenericGenerator(name = "wikiSequenceGenerator15", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_Ug_Specialization_seq"),
			@Parameter(name = "initial_value", value = "36"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator15")
			private Integer UID;
			@Id
			@Column(name="UGSPECIALISATIONKEY")
			private String UGSPECIALIZATIONKEY;
			@Column(name="UGSPECIALISATIONVALUE")
			private String UGSPECIALIZATIONVALUE;

}
