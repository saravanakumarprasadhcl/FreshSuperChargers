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
@Table(name = "master_onboardingstatus")
public class OnboardingStatus {
	
	@GenericGenerator(name = "wikiSequenceGenerator16", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {

			@Parameter(name = "sequence_name", value = "master_Onboarding_Status_seq"),
			@Parameter(name = "initial_value", value = "3"), @Parameter(name = "increment_size", value = "1") })

			@GeneratedValue(generator = "wikiSequenceGenerator16")
			private Integer UID;
			@Id
			@Column(name = "ONBORADINGSTATUSKEY")
			private String ONBOARDINGSTATUSKEY;
			@Column(name = "ONBOARDINGSTATUSVALUE")
			private String ONBOARDINGSTATUSVALUE;


}
