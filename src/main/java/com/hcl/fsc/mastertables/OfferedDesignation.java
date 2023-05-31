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
@Table(name = "Master_Offered_Designation")
public class OfferedDesignation {
	
	@GenericGenerator(name = "wikiSequenceGenerator13", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_Offered_Designation_seq"),
			@Parameter(name = "initial_value", value = "6"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator13")
			private Integer UID;
			@Id
			@Column(name="OFFEREDDESIGNATIONKEY")
			private String OFFEREDDESIGNATIONKEY;
			@Column(name="OFFEREDDESIGNATIONVALUE")
			private String OFFEREDDESIGNATIONVALUE;

}
