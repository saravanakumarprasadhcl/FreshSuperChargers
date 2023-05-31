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
@Table(name = "Master_Region")
public class Region {
	
	@GenericGenerator(name = "wikiSequenceGenerator4", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_region_seq"),
			@Parameter(name = "initial_value", value = "5"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator4")
			private Integer UID;
			@Id
			@Column(name = "REGIONKEY")
			private String REGIONKEY;
			@Column(name = "REGIONVALUE")
			private String REGIONVALUE;

}
