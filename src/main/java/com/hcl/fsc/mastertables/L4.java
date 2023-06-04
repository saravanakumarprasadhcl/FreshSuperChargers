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
@Table(name = "Master_L4")
public class L4 {
	
	@GenericGenerator(name = "wikiSequenceGenerator10", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_l4_seq"),
			@Parameter(name = "initial_value", value = "69"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator10")
			private Integer UID;
			@Id
			@Column(name="L4KEY")
			private String L4KEY;
			@Column(name="L4VALUE")
			private String L4VALUE;

}
