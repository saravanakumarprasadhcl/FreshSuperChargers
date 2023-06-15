package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.entities.EmployeeEducationalDetails;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.excel.vivo.Tier1;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.helpers.ResponseList;
import com.hcl.fsc.repositories.CollegeTieringRepository;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationalDetailsRepository;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.GraduationSpecializationRepository;
import com.hcl.fsc.repositories.L1Repository;
import com.hcl.fsc.repositories.L2Repository;
import com.hcl.fsc.repositories.L3Repository;
import com.hcl.fsc.repositories.L4Repository;
import com.hcl.fsc.repositories.LobRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;
import com.hcl.fsc.repositories.UgDegreeRepository;

@Service
public class EmployeeTier1Service {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private EmployeeEducationalDetailsRepository employeeEducationDetailsRepository;

	@Autowired
	private EmployeeOnboardingDetailsRepository employeeOnboardingDetailsRepository;

	@Autowired
	private EmployeeRecruitmentDetailsRepository employeeRecruitmentDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private UGOrPGRepository ugOrPGRepository;

	@Autowired
	private UgDegreeRepository ugDegreeRepository;

	@Autowired
	private GraduationSpecializationRepository graduationSpecializationRepository;

	@Autowired
	private CollegeTieringRepository collegeTieringRepository;

	@Autowired
	private L1Repository l1Repository;

	@Autowired
	private L2Repository l2Repository;

	@Autowired
	private L3Repository l3Repository;

	@Autowired
	private L4Repository l4Repository;

	@Autowired
	private LobRepository lobRepository;

	@Autowired
	private OfferedDesignationRepository offeredDesignationRepository;

	@Autowired
	private OfferedBandRepository offeredBandRepository;

	@Autowired
	private OfferedSubBandRepository offeredSubBandRepository;

//	@Autowired
//	private LocationRepository locationRepository;

	int rowNumber = 2;
	int duplicateCount = 0;

	public ResponseList employeeTier1ListSave(MultipartFile file) {

		List<String> errorsList = new ArrayList<>();
		ResponseList responseList = new ResponseList();
		List<String> duplicateSapIdList = new ArrayList<>();

		try {

			List<Tier1> employeeTier1List = EmployeeHelper.convertExcelToListOfTier1(file.getInputStream());
			System.out.println(employeeTier1List);
			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();
			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();
			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

//getting the data from Tier1 and mapping it to employee details entity after validating the data from related master tables
//			rowNumber = 2;
//			duplicateCount = 0;
			employeeTier1List.stream().forEach(e -> {

				boolean flag = true;
				if (e.getSapId() != null) {
					System.out.println(
							e.getSapId() + " checking sap-id " + employeeDetailsRepository.findById(e.getSapId()));
					if (employeeDetailsRepository.findById(e.getSapId()).equals(Optional.empty())) {
						if (!Constraints.nameValidate(e.getName())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in tier1 excel sheet");
							flag = true;
						}
						if (!Constraints.mobileNumberValidate(e.getContactNo())) {
							errorsList.add("Contact number is not Correct at row" + rowNumber + " in tier1 excel sheet");
							flag = true;
						}
						if (!Constraints.emailValidate(e.getEmail())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in tier1 excel sheet");
							flag = true;
						}

						if (genderRepository.findByValue(e.getGender()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in gender column of tier1 excel sheet");
							flag = false;
						}
						if (regionRepository.findByValue(e.getRegion()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in region column of tier1 excel sheet");
							flag = false;
						}
						if (stateRepository.findByValue(e.getState()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in state column of tier1 excel sheet");
							flag = false;
						}
						System.out.println(e.getUgDegree()+"--"+ugDegreeRepository.findByValue("Bachelor of Engineering "));
						if (ugDegreeRepository.findByValue(e.getUgDegree()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in ug-degree column of tier1 excel sheet");
							flag = false;
						}
						System.out.println(e.getUgOrPg());	
						if (ugOrPGRepository.findByValue(e.getUgOrPg()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in ug-or-pg column of tier1 excel sheet");
							flag = false;
						}
						System.out.println(e.getGraduationSpecialization()+"--"+graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
						if (graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in graduation-specialization column of tier1 excel sheet");
							flag = false;
						}
                        System.out.println(e.getCollegeTiering());	
                        if (collegeTieringRepository.findByValue(e.getCollegeTiering()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in college-tiering column of tier1 excel sheet");
							flag = false;
						}
						if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-designation column of tier1 excel sheet");
							flag = false;
						}
						 System.out.println(e.getOfferedBand());
						if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-band column of tier1 excel sheet");
							flag = false;
						}
						System.out.println(e.getOfferedSubBand());
						if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-sub-band column of tier1 excel sheet");
							flag = false;
						}
						if (lobRepository.findByValue(e.getLob()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in lob column of tier1 excel sheet");
							flag = false;
						}
						if (l1Repository.findByValue(e.getL1()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L1 column of tier1 excel sheet");
							flag = false;
						}
						if (l2Repository.findByValue(e.getL2()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L2 column of tier1 excel sheet");
							flag = false;
						}
						if (l3Repository.findByValue(e.getL3()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L3 column of tier1 excel sheet");
							flag = false;
						}
						if (l4Repository.findByValue(e.getL4()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L4 column of tier1 excel sheet");
							flag = false;
						}
						if (flag == true) {
							EmployeeDetails employeeDetails = new EmployeeDetails();
							employeeDetails = modelMapper.map(e, EmployeeDetails.class);
							employeeDetails.setGender(genderRepository.findByValue(e.getGender()));
							employeeDetails.setRegion(regionRepository.findByValue(e.getRegion()));
							employeeDetails.setState(stateRepository.findByValue(e.getState()));
							employeeDetails.setSheetCode("Tier1");
							employeeDetailsList.add(employeeDetails);

							EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();
							employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);	
							employeeEducationalDetails.setUgDegree(ugDegreeRepository.findByValue(e.getUgDegree()));
							employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));
							employeeEducationalDetails.setGraduationSpecialization(
									graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
							employeeEducationalDetails.setSheetCode("Tier1");
							employeeEducationalDetailsList.add(employeeEducationalDetails);

							EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();
							employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);
							employeeOnboardingDetails
									.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));

							employeeOnboardingDetails.setOfferedDesignation(
									offeredDesignationRepository.findByValue(e.getOfferedDesignation()));
							employeeOnboardingDetails
									.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));
							employeeOnboardingDetails
									.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));
							employeeOnboardingDetails.setSheetCode("Tier1");
							employeeOnboardingDetailsList.add(employeeOnboardingDetails);

							EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();
							employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);
							employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));
							employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));
							employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));
							employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));
							employeeRecruitmentDetails.setSheetCode("Tier1");
							employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

						} 
					} else { 
						errorsList.add("duplicate entry at row no " + rowNumber
								+ " in tier1 excel sheet this sap-id is already present in the database");
						duplicateSapIdList.add(e.getSapId().toString());
						duplicateCount++;
						flag = false;
					}
				} else {
					errorsList.add("sap-id is null or improper in row no " + rowNumber + " in the tier1 excel sheet");
				}
				rowNumber++;

			});

			// System.out.println(employeeDetailsList);
			employeeDetailsRepository.saveAll(employeeDetailsList);
			// System.out.println(employeeEducationalDetailsList);
			employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);
			// System.out.println(employeeOnboardingDetailsList);
			employeeOnboardingDetailsRepository.saveAll(employeeOnboardingDetailsList);
			// System.out.println(employeeRecruitmentDetailsList);
			employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);

			responseList.setTotal_No_Records(employeeTier1List.size());
			responseList.setSucessful_Records(employeeDetailsList.size());
			responseList.setFailed_Records(employeeTier1List.size() - employeeDetailsList.size());
			responseList.setDuplicate_Records(duplicateCount);
			responseList.setDuplicate_Sap_List(duplicateSapIdList);
			Map<String, List<String>> failed_Records_List = new HashMap<>();
			failed_Records_List.put("Tier1", errorsList);
			responseList.setFailed_Records_List(failed_Records_List);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return responseList;
	}

}
