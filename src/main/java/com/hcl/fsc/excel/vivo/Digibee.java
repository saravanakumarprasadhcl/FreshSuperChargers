package com.hcl.fsc.excel.vivo;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@ExcelSheet("DigiBee")
public class Digibee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;  
	@ExcelCellName("SAP")
	private Integer sapId;	
	@ExcelCellName("Student Name")
	private String name;
	@ExcelCellName("Gender")
	private String gender;
	@ExcelCellName("Email")
	private String email;	
	@ExcelCellName("Contact")
	private Long contactNo;		
	@ExcelCellName("Complete Permanent Address (as per Aadhar)")
	private String address;	
	@ExcelCellName("State Name")
	private String state;
	@ExcelCellName("Region")
	private String region;
	@ExcelCellName("10th Passing Year")
    private String highSchoolPassingYear;
	@ExcelCellName("12th Passing Year")
	private String  intermediatePassingYear;
	@ExcelCellName("12th Percantage")
	private String  intermediatePercentage;
    @ExcelCellName("Graduation College")
	private String  graduationCollege;
    @ExcelCellName("Graduation Specialization")
	private String  graduationSpecialization;
    @ExcelCellName("Graduation Passing Year")
	private String  graduationPassingYear;
    @ExcelCellName("Post Graduation Degree")
	private String postGraduationDegree;
    @ExcelCellName("Post Graduation Specialisation")
	private String  postGraduationSpecialisation;
    @ExcelCellName("post Graduation Passing Year")
	private String  postGraduationPassingYear;
    @ExcelCellName("PG College Name")
	private String  PGCollegeName;
    @ExcelCellName("UG/PG")
	private String UGOrPG;
    @ExcelCellName("Drive College")
	private String driveCollege;
    @ExcelCellName("Drive Date")
	private String driveDate;
	@ExcelCellName("Offered Designation")
	private String offeredDesignation;
	@ExcelCellName("Offered Band")
	private String offeredBand; 
	@ExcelCellName("Offered Sub Band")
	private String offeredSubBand;
	@ExcelCellName("College Tiering")
	private String collegeTiering ;
	@ExcelCellName("TP Panel")
	private String TPPanel;
	@ExcelCellName("TP Sap")
	private String TPSap;
	@ExcelCellName("FPM SPOC")
	private String FPM_SPOC;
	@ExcelCellName("Location")
	private String location;
	@ExcelCellName("Intern Joining Status")
	private String internJoiningStatus;
	@ExcelCellName("Intern Joining Date")
	private String internJoiningDate;
	@ExcelCellName("Intern SAP ID")
	private String internSapID;
	@ExcelCellName("H1/H2")
	private String H1OrH2;
	@ExcelCellName("Pre OTP Status")
	private String preOTPStatus;
	@ExcelCellName("Tentative Joining Month")
	private String tentativeJoiningMonth;
	@ExcelCellName("Tentative Joining QTR")
	private String tentativeJoiningQTR;
	@ExcelCellName("Tentative DOJ")
	private String tentativeDOJ;
	@ExcelCellName("Joining Status")
	private String joiningStatus;
	@ExcelCellName("L1")
	private String L1;
	@ExcelCellName("L2")
	private String L2;
	@ExcelCellName("L3")
	private String L3;
	@ExcelCellName("L4")
	private String L4;
	@ExcelCellName("Final Status")
	private String finalStatus;
	@ExcelCellName("Demand Owner")
	private String demandOwner;
}
