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
@Table(name = "Master_Offered_Band")
public class OfferedBand {
	
	@GenericGenerator(name = "wikiSequenceGenerator11", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_Offered_Band_seq"),
			@Parameter(name = "initial_value", value = "3"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator11")
			private Integer UID;
			@Id
			@Column(name="OFFEREDBANDKEY")
			private String OFFEREDBANDKEY;
			@Column(name="OFFEREDBANDVALUE")
			private String OFFEREDBANDVALUE;

}
