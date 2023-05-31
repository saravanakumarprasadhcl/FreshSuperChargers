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
@Table(name = "Master_College_Tiering")
public class CollegeTiering {
	
	@GenericGenerator(name = "wikiSequenceGenerator5", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_college_tiering_seq"),
			@Parameter(name = "initial_value", value = "6"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator5")
			private Integer UID;
			@Id
			@Column(name="COLLEGETIERINGKEY")
			private String COLLEGETIERINGKEY;
			@Column(name="COLLEGETIERINGVALUE")
			private String COLLEGETIERINGVALUE;

}
