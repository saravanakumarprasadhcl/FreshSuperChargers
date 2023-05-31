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
//@SequenceGenerator(name="GENDER_SEQUENCE_GENERATOR", sequenceName="GENDER_SEQUENCE", initialValue=521, allocationSize=1)
@Table(name = "Master_lob")
public class Lob {
	@GenericGenerator(name = "wikiSequenceGenerator2", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_gender_seq"),
			@Parameter(name = "initial_value", value = "2"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator2")
			private Integer UID;
			@Id
			@Column(name="LOBKEY")
			private String LOBKEY;
			@Column(name="LOBVALUE")
			private String LOBVALUE;
}
