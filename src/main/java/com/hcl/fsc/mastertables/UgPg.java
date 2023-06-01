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
@Table(name = "Master_Ug_Pg")
public class UgPg {


	@GenericGenerator(name = "wikiSequenceGenerator14", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_ug_Pg_seq"),
			@Parameter(name = "initial_value", value = "3"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator14")
			private Integer UID;
			@Id
			@Column(name="UGorPGKEY")
			private String UGPGKEY;
			@Column(name="UGorPGVALUE")
			private String UGPGVALUE;
}
