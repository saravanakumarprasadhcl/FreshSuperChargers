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
@Table(name = "Master_lob")
public class Lob {
	@GenericGenerator(name = "wikiSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_lob_seq"),
			@Parameter(name = "initial_value", value = "4"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator")
			private Integer UID;
			@Id
			private String LOBKEY;
			private String LOBVALUE;
}
