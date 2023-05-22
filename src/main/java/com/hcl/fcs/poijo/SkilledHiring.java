package com.hcl.fcs.poijo;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ExcelSheet("Skilled Hiring")
public class SkilledHiring {
	
	@ExcelCellName("S.No")
	private Integer SNo;	
	
	@ExcelCellName("University Registration ID")
	private String universityRegistrationId;
	
	@ExcelCellName("Candidate name as per 10th Mark sheet")
	private String studentName;
	
	@ExcelCellName("Gender")
	private String gender;
	
	@ExcelCellName("Mobile No")
	private String contact;
	
	@ExcelCellName("Alternate Number")
	private String alternateContactNo;
	
	@ExcelCellName("Email Id")
	private String email;
	
	@ExcelCellName("Address")
	private String address;
	
	@ExcelCellName("State")
	private String stateName;
	
	@ExcelCellName("Region")
	private String region;
	
	
	@ExcelCellName("10th Passing year")
	private String passingYear10th;
	
	
	@ExcelCellName("12th Passing year")
	private String passingYear12th;
	
	@ExcelCellName("UG College name")
	private String graduationCollege;
	
	@ExcelCellName("UG Degree/Specialisation")
	private String ugDegree;
	
	@ExcelCellName("UG  passing year")
	private String graduationPassingYear;
	
	@ExcelCellName("PG College name")
	private String pgCollegeName;
	
	@ExcelCellName("PG Degree/Specialisation")
	private String pgDegree;
	
	@ExcelCellName("PG  passing year")
	private String postGraduationPassingYear;
	
	@ExcelCellName("UG/PG")
	private String UG_PG;
	
	@ExcelCellName("Drive College")
	private String driveCollege;
	
	@ExcelCellName("Drive Date")
	private String driveDate;
	
	@ExcelCellName("Offered Designation")
	private String offeredDesignation;
	
	@ExcelCellName("Final Status")	
	private String finalStatus;
	
	
	@ExcelCellName("Band")
	private String offeredBand;
	
	
	@ExcelCellName("Sub-Band")
	private String offeredSubBand;
	
	@ExcelCellName("TP")
	private String tp;
	
	@ExcelCellName("TP SAP")
	private String tpSap;
	
	@ExcelCellName("Project Skills")
	private String projectSkills;
	
	@ExcelCellName("Demand Owner")
	private String demandOwner;
	
	@ExcelCellName("Demand Owner SAP")
	private String demandOwnerSAP;
	
	@ExcelCellName("L2")
	private String L2;
	
	@ExcelCellName("L3")
	private String L3;
	
	@ExcelCellName("L4")
	private String L4;
	
	@ExcelCellName("Location")
	private String location;
	
	@ExcelCellName("SR Mapping")
	private String srMapping;
	
	@ExcelCellName("OB Recruiter")
	private String obRecruiter;
	
	@ExcelCellName("BR")
	private String br;
	
	@ExcelCellName("H1/H2")
	private String h1_h2;
	
	@ExcelCellName("Tentative DOJ")
	private String tentativeDOJ;
	
	@ExcelCellName("Month")
	private String month;
	
	@ExcelCellName("Joining QTR")
	private String joiningQtr;
	
	
	@ExcelCellName("Joining Status")
	private String joiningStatus;
	
	
	@ExcelCellName("SAP Code")
	private String sapId;
	
	@ExcelCellName("Remarks")
	private String remarks;

}
