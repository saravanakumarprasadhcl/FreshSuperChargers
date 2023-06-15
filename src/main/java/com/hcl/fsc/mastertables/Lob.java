package com.hcl.fsc.mastertables;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer uid;
	@Id
	private String key;
	private String value;
	}
