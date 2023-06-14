package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.entities.EmployeeEducationalDetails;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.excel.vivo.SkilledHiring;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.helpers.ResponseList;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationalDetailsRepository;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.L2Repository;
import com.hcl.fsc.repositories.L3Repository;
import com.hcl.fsc.repositories.L4Repository;
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;
import com.hcl.fsc.repositories.UgDegreeRepository;

@Service
public class EmployeeSkilledHiringService {

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

//	@Autowired
//	private GraduationSpecializationRepository graduationSpecializationRepository;
//
//	@Autowired
//	private CollegeTieringRepository collegeTieringRepository;
//
//	@Autowired
//	private L1Repository l1Repository;

	@Autowired
	private L2Repository l2Repository;

	@Autowired
	private L3Repository l3Repository;

	@Autowired
	private L4Repository l4Repository;

//	@Autowired
//	private LobRepository lobRepository;

	@Autowired
	private OfferedDesignationRepository offeredDesignationRepository;

	@Autowired
	private OfferedBandRepository offeredBandRepository;

	@Autowired
	private OfferedSubBandRepository offeredSubBandRepository;

	@Autowired
	private LocationRepository locationRepository;

	int rowNumber = 2;
	int duplicateCount = 0;

//	ResponseList responseList = new ResponseList();
//	List<String> duplicateSapIdList = new ArrayList<>();

	public ResponseList employeeSkilledHiringListSave(MultipartFile file) {

		List<String> errorsList = new ArrayList<>();
		ResponseList responseList = new ResponseList();
		List<String> duplicateSapIdList = new ArrayList<>();

		try {

			List<SkilledHiring> employeeSkilledHiringList = EmployeeHelper
					.convertExcelToListOfSkilledHiring(file.getInputStream());
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			System.out.println(employeeSkilledHiringList);

			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();
			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();
			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

			// getting the data from skilled-hiring and mapping it to employee details
			// entity after
			// validating the data from related master tables
//			rowNumber = 2;
//			duplicateCount = 0;
			employeeSkilledHiringList.stream().forEach(e -> {

				boolean flag = true;
				if (e.getSapId() != null) {
					System.out.println(
							e.getSapId() + " checking sap-id " + employeeDetailsRepository.findById(e.getSapId()));
					if (employeeDetailsRepository.findById(e.getSapId()).equals(Optional.empty())) {
						if (!Constraints.nameValidate(e.getName())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in skilled-hiring excel sheet");
							flag = true;
						}
						if (!Constraints.mobileNumberValidate(e.getContactNo())) {
							errorsList.add("Contact number is not Correct at row" + rowNumber + " in skilled-hiring excel sheet");
							flag = true;
						}
						if (!Constraints.emailValidate(e.getEmail())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in skilled-hiring excel sheet");
							flag = true;
						}

						if (genderRepository.findByValue(e.getGender()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in gender column of skilled-hiring excel sheet");
							flag = false;
						}
						if (regionRepository.findByValue(e.getRegion()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in region column of skilled-hiring excel sheet");
							flag = false;
						}
						if (stateRepository.findByValue(e.getState()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in state column of skilled-hiring excel sheet");
							flag = false;
						}
//						System.out.println(
//								e.getUgDegree() + "--" + ugDegreeRepository.findByValue("Bachelor of Engineering "));
//						if (ugDegreeRepository.findByValue(e.getUgDegree()) == null) {
//							errorsList.add("values are null in row " + rowNumber
//									+ " in ug-degree column of skilled-hiring excel sheet");
//							flag = false;
//						}
						System.out.println(e.getUgOrPg());
						if (ugOrPGRepository.findByValue(e.getUgOrPg()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in ug-or-pg column of skilled-hiring excel sheet");
							flag = false;
						}
//						System.out.println(e.getGraduationSpecialization() + "--"
//								+ graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
//						if (graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) == null) {
//							errorsList.add("values are null in row " + rowNumber
//									+ " in graduation-specialization column of tier1 excel sheet");
//							flag = false;
//						}
//						System.out.println(e.getCollegeTiering());
//						if (collegeTieringRepository.findByValue(e.getCollegeTiering()) == null) {
//							errorsList.add("values are null in row " + rowNumber
//									+ " in college-tiering column of tier1 excel sheet");
//							flag = false;
//						}
						if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-designation column of skilled-hiring excel sheet");
							flag = false;
						}
						System.out.println(e.getOfferedBand());
						if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-band column of skilled-hiring excel sheet");
							flag = false;
						}
						System.out.println(e.getOfferedSubBand());
						if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-sub-band column of skilled-hiring excel sheet");
							flag = false;
						}
						if (locationRepository.findByValue(e.getLocation()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in location column of skilled-hiring excel sheet");
							flag = false;
						}
//						if (lobRepository.findByValue(e.getLob()) == null) {
//							errorsList
//									.add("values are null in row " + rowNumber + " in lob column of tier1 excel sheet");
//							flag = false;
//						}
//						if (l1Repository.findByValue(e.getL1()) == null) {
//							errorsList
//									.add("values are null in row " + rowNumber + " in L1 column of tier1 excel sheet");
//							flag = false;
//						}
						if (l2Repository.findByValue(e.getL2()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in L2 column of skilled-hiring excel sheet");
							flag = false;
						}
						if (l3Repository.findByValue(e.getL3()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in L3 column of skilled-hiring excel sheet");
							flag = false;
						}
						if (l4Repository.findByValue(e.getL4()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in L4 column of skilled-hiring excel sheet");
							flag = false;
						}
						if (flag == true) {
							EmployeeDetails employeeDetails = new EmployeeDetails();
							employeeDetails = modelMapper.map(e, EmployeeDetails.class);
							employeeDetails.setGender(genderRepository.findByValue(e.getGender()));
							employeeDetails.setRegion(regionRepository.findByValue(e.getRegion()));
							employeeDetails.setState(stateRepository.findByValue(e.getState()));
							employeeDetails.setSheetCode("Skilled Hiring");
							employeeDetailsList.add(employeeDetails);

							EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();
							employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);
							employeeEducationalDetails.setUgDegree(ugDegreeRepository.findByValue(e.getUgDegree()));
							employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));
//							employeeEducationalDetails.setGraduationSpecialization(
//									graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
							employeeEducationalDetails.setSheetCode("Skilled Hiring");
							employeeEducationalDetailsList.add(employeeEducationalDetails);

							EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();
							employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);
//							employeeOnboardingDetails
//									.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));

							employeeOnboardingDetails.setOfferedDesignation(
									offeredDesignationRepository.findByValue(e.getOfferedDesignation()));
							employeeOnboardingDetails
									.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));
							employeeOnboardingDetails
									.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));
							
							employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));
							employeeOnboardingDetails.setSheetCode("Skilled Hiring");
							employeeOnboardingDetailsList.add(employeeOnboardingDetails);

							EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();
							employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);
							// employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));
							employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));
							employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));
							employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));
							employeeRecruitmentDetails.setSheetCode("Skilled Hiring");
							employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

						}
					} else {
						errorsList.add("duplicate entry at row no " + rowNumber
								+ " in mou excel sheet this sap-id is already present in the database");
						duplicateSapIdList.add(e.getSapId().toString());
						duplicateCount++;
						flag = false;
					}
				} else {
					errorsList.add("sap-id is null or improper in row no " + rowNumber + " in the mou excel sheet");
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

			responseList.setTotal_No_Records(employeeSkilledHiringList.size());
			responseList.setSucessful_Records(employeeDetailsList.size());
			responseList.setFailed_Records(employeeSkilledHiringList.size() - employeeDetailsList.size());
			responseList.setDuplicate_Records(duplicateCount);
			responseList.setDuplicate_Sap_List(duplicateSapIdList);
			Map<String, List<String>> failed_Records_List = new HashMap<>();
			failed_Records_List.put("Skilled Hiring", errorsList);
			responseList.setFailed_Records_List(failed_Records_List);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return responseList;

	}

}
