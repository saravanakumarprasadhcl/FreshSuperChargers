package com.hcl.fsc.excel.vivo;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@ExcelSheet("CDAC")
public class CDAC {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	@ExcelCellName("SAP")
	private String sapId;
	@ExcelCellName("Candidate Name")
	private String name;
	@ExcelCellName("gender")
	private String gender;
	@ExcelCellName("Mobile Number")
	private String contact;
	@ExcelCellName("E-mail ID")
	private String email;
	@ExcelCellName("Address")
	private String address;
	@ExcelCellName("State")
	private String state;
	@ExcelCellName("Region")
	private String region;
	@ExcelCellName("batch")
	private String batch;
	@ExcelCellName("10th Passing Year")
    private String highSchoolPassingYear;
	@ExcelCellName("12th Passing Year")
	private String  intermediatePassingYear;
    @ExcelCellName("UG College name")
	private String  graduationCollege;
    @ExcelCellName("UG DegreeDegree/Specialization")
	private String  graduationSpecialization;
    @ExcelCellName("UG Passing Year")
	private String  graduationPassingYear;
    @ExcelCellName("Drive College")
	private String driveCollege;
    @ExcelCellName("Drive Date")
	private String driveDate;
	@ExcelCellName("Designation")
	private String offeredDesignation;
	@ExcelCellName("Band")
	private String offeredBand; 
	@ExcelCellName("Sub Band")
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
	@ExcelCellName("Month")
	private String month;
	@ExcelCellName("Tentative Joining QTR")
	private String tentativeJoiningQTR;
	@ExcelCellName("Planned DOJ")
	private String plannedDOJ;
	@ExcelCellName("Joining Status")
	private String joiningStatus;
	@ExcelCellName("LOB")
	private String lob;
	@ExcelCellName("L2")
	private String L2;
	@ExcelCellName("Team/RDU")
	private String teamOrRDU;
	@ExcelCellName("Final Status")
	private String finalStatus;
	@ExcelCellName("Demand Owner")
	private String demandOwner;
	@ExcelCellName("Demand Owner SAP")
	private String demandOwnerSap;

}
