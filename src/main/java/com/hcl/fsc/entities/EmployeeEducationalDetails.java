package com.hcl.fsc.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;
    private Long sapId;
    private String batch;
    private String highSchoolPassingYear;
	private String intermediatePercentage;
	private String IntermediatePassingYear;
	private String graduationCollege;
	private String ugDegree;
	private String graduationSpecialization;
	private String graduationPassingYear;
	private Long   universityRegistrationId;
	private String postGraduationDegree;
	private String postGraduationSpecialisation;
	private String postGraduationPassingYear;
	private String postGraduationPercentage;
	private String PGCollegeName;
 	private String ug_pg;


}
