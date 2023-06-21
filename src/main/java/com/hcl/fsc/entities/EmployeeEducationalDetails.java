package com.hcl.fsc.entities;

import com.hcl.fsc.mastertables.GraduationSpecialization;
import com.hcl.fsc.mastertables.UGOrPG;
import com.hcl.fsc.mastertables.UGDegree;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class EmployeeEducationalDetails {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private Long sapId;
    private String batch;
    private String highSchoolPassingYear;
	private String intermediatePercentage;
	private String intermediatePassingYear;
	private String graduationCollege;
	//master table
	@OneToOne
	private UGDegree ugDegree;
	//master table
	@OneToOne
	private GraduationSpecialization graduationSpecialization;
	private String graduationPassingYear;
	private Long universityRegistrationId;
	private String postGraduationDegree;
	private String postGraduationSpecialisation;
	private String postGraduationPassingYear;
	private String postGraduationPercentage;
	private String pgCollegeName;
	//master table
	@OneToOne
	private UGOrPG ugOrPg;


}
