package com.hcl.fsc.excel.vivo;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ExcelSheet("Tier-1")
public class Tier1 {
	
	private Long id;
	
	@ExcelCellName("Student Name")
	private String studentName;	
	
	@ExcelCellName("Gender")
	private String gender;
	
	@ExcelCellName("Email")
	private String email;
	
	@ExcelCellName("Ownership")
	private String ownership;	
	
	@ExcelCellName("Contact")
	private String contact;
	
	@ExcelCellName("State Name")
	private String stateName;	
	
	@ExcelCellName("Address")
	private String address;
	
	@ExcelCellName("Region")
	private String region;	
	
	@ExcelCellName("10th Passing Year")
	private String passingYear10th;	
	
	@ExcelCellName("12th Passing Year")
	private String passingYear12th;	
	
	@ExcelCellName("Graduation College")
	private String graduationCollege;	
	
	@ExcelCellName("UG Degree")
	private String ugDegree;	
	
	@ExcelCellName("UG Specialization")
	private String ugSpecialization;	
	
	@ExcelCellName("Graduation Passing Year")
	private String graduationPassingYear;
	
	@ExcelCellName("PG Degree")
	private String pgDegree;
	
	@ExcelCellName("PG Specialization")
	private String pgSpecialization;	
	
	@ExcelCellName("Post Graduation Percentage (incase of CGPA please convert and mention %)")
	private String postGraduationPercentage;	
	
	@ExcelCellName("Post Graduation Passing Year")
	private String postGraduationPassingYear;	
	
	@ExcelCellName("PG College Name")
	private String pgCollegeName;	
	
	@ExcelCellName("UG/PG")
	private String UG_PG;	
	
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
	private String collegeTiering; 	
	
	@ExcelCellName("TP Panel")
	private String tPPanel;	
	
	@ExcelCellName("TP SAP Code")
	private String tPSAPCode;	
	
	@ExcelCellName("LOB")
	private String lob;
	
	@ExcelCellName("Team/RDU")
	private String team_RDU;
	
	@ExcelCellName("L1")
	private String l1;	
	
	@ExcelCellName("L2")
	private String l2;	
	
	@ExcelCellName("L3")
	private String l3;	
	
	@ExcelCellName("L4")
	private String l4;	
	
	@ExcelCellName("HR Panel")
	private String hRPanel;
	
	@ExcelCellName("Demand Owner")
	private String demandOwner;	
	
	@ExcelCellName("Demand Owner SAP")
	private String demandOwnerSAP;
	
	@ExcelCellName("Final Status")
	private String finalStatus;	

	@ExcelCellName("Remark")
	private String remark;	
	
	@ExcelCellName("Candidate Mapping")
	private String candidateMapping;	
	
	@ExcelCellName("BS")
	private String bs;	
	
	@ExcelCellName("Dummy/Original")
	private String dummy_Original;	
	
	@ExcelCellName("SR Status")
	private String srStatus;	
	
	@ExcelCellName("Joining Status")
	private String joiningStatus;	

	@ExcelCellName("SAP ID")
	private Long sapID;	
	
	@ExcelCellName("Requisition Source")
	private String requisitionSource;	
	
	@ExcelCellName("Planned DOJ")
	private String plannedDOJ;	
	
	@ExcelCellName("Month")
	private String month;	
	
	@ExcelCellName("Joining QTR")
	private String joiningQTR;
	
	@ExcelCellName("H1/H2")
	private String h1_h2;	
	
	@ExcelCellName("Current Batch Code")
	private String currentBatchCode;
	
	@ExcelCellName("Required Batch Code")
	private String requiredBatchCode;
	
	@ExcelCellName("Remapped Profile")
	private String remappedProfile;	
	
	@ExcelCellName("Remapped Location")
	private String remappedLocation;	
	
	@ExcelCellName("Acknowledgement")
	private String acknowledgement;
	
	
//	--------------------------------------------------  //
//	private String intermediatePercentage;
//	private String batch;
	
}

