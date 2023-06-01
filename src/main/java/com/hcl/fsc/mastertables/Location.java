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
@Table(name = "Master_Location")
public class Location {

		@GenericGenerator(name = "wikiSequenceGenerator3", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

				@Parameter(name = "sequence_name", value = "master_location_seq"),
				@Parameter(name = "initial_value", value = "6"), @Parameter(name = "increment_size", value = "1") })

				@GeneratedValue(generator = "wikiSequenceGenerator3")
				private Integer UID;
				@Id
				@Column(name="LOCATIONKEY")
				private String LOCATIONKEY;
				@Column(name="LOCATIONVALUE")
				private String LOCATIONVALUE;

}
