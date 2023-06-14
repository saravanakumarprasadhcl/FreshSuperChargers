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
import com.hcl.fsc.excel.vivo.DigiBee;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.helpers.ResponseList;
import com.hcl.fsc.mastertables.Gender;
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
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;

@Service
public class EmployeeDigiBeeServiceImpl {
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

//	@Autowired
//	private UGDegreeRepository ugDegreeRepository;

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

	@Autowired
	private LocationRepository locationRepository;

	int rowNumber = 2;
	int duplicateRow = 0;

//	ResponseList responseList = new ResponseList();
//	List<String> duplicateSapIdList = new ArrayList<>();
	
	public ResponseList employeeDigiBeeListSave(MultipartFile file) {
		
		List<String> errorsList = new ArrayList<>();
		ResponseList responseList = new ResponseList();
		List<String> duplicateSapIdList = new ArrayList<>();
		try {
			List<DigiBee> employeeDigiBeeList = EmployeeHelper.convertExcelToListOfDigibee(file.getInputStream());
			//System.out.println(employeeDigiBeeList + "in digibee sheet");


			rowNumber = 2;
			duplicateRow = 0;
			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();
			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();
			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

//getting the data from NonTier1 and mapping it to employee details entity after validating the data from related master tables
			
			employeeDigiBeeList.stream().forEach(e -> {

				boolean flag = true;
				if (e.getSapId() != null) {
					System.out.println(
							e.getSapId() + " checking sap-id " + employeeDetailsRepository.findById(e.getSapId()));
					if (employeeDetailsRepository.findById(e.getSapId()).equals(Optional.empty())) {
						if (!Constraints.nameValidate(e.getName())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in digibee excel sheet");
							flag = true;
						}
						if (!Constraints.mobileNumberValidate(e.getContactNo().toString())) {
							errorsList.add("Contact number is not Correct at row" + rowNumber + " in digibee excel sheet");
							flag = true;
						}
						if (!Constraints.emailValidate(e.getEmail())) {
							errorsList.add("Email Id is not Correct at row" + rowNumber + " in digibee excel sheet");
							flag = true;
						}

						if (genderRepository.findByValue(e.getGender()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in gender column of digibee excel sheet");
							flag = false;
						}
						if (regionRepository.findByValue(e.getRegion()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in region column of digibee excel sheet");
							flag = false;
						}
						if (stateRepository.findByValue(e.getState()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in state column of digibee excel sheet");
							flag = false;
						}
						if (ugOrPGRepository.findByValue(e.getUgOrPg()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in ug-or-pg column of digibee excel sheet");
							flag = false;
						}
						if (graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in graduation-specialization column of digibee excel sheet");
							flag = false;
						}
						if (locationRepository.findByValue(e.getLocation()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in location column of digibee excel sheet");
							flag = false;
						}

						if (collegeTieringRepository.findByValue(e.getCollegeTiering()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in college-tiering column of digibee excel sheet");
							flag = false;
						}
						if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-designation column of digibee excel sheet");
							flag = false;
						}
						if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-band column of digibee excel sheet");
							flag = false;
						}
						if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-sub-band column of digibee excel sheet");
							flag = false;
						}
						if (l1Repository.findByValue(e.getL1()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L1 column of digibee excel sheet");
							flag = false;
						}
						if (l2Repository.findByValue(e.getL2()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L2 column of digibee excel sheet");
							flag = false;
						}
						if (l3Repository.findByValue(e.getL3()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L3 column of digibee excel sheet");
							flag = false;
						}
						if (l4Repository.findByValue(e.getL4()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in L4 column of digibee excel sheet");
							flag = false;
						}
						if (flag == true) {
							EmployeeDetails employeeDetails = new EmployeeDetails();
							employeeDetails = modelMapper.map(e, EmployeeDetails.class);
							employeeDetails.setGender(genderRepository.findByValue(e.getGender()));
							employeeDetails.setRegion(regionRepository.findByValue(e.getRegion()));
							employeeDetails.setState(stateRepository.findByValue(e.getState()));
							employeeDetails.setSheetCode("DigiBee");
							employeeDetailsList.add(employeeDetails);

							EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();
							employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);
							employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));
							employeeEducationalDetails.setGraduationSpecialization(
									graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
							employeeEducationalDetails.setSheetCode("DigiBee");
							employeeEducationalDetailsList.add(employeeEducationalDetails);

							EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();
							employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);
							employeeOnboardingDetails
									.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));
							employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));
							employeeOnboardingDetails.setOfferedDesignation(
									offeredDesignationRepository.findByValue(e.getOfferedDesignation()));
							employeeOnboardingDetails
									.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));
							employeeOnboardingDetails
									.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));
							employeeOnboardingDetails.setSheetCode("DigiBee");
							employeeOnboardingDetailsList.add(employeeOnboardingDetails);

							EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();
							employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);
							employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));
							employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));
							employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));
							employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));
							employeeRecruitmentDetails.setSheetCode("DigiBee");
							employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

						}
					} else {
						errorsList.add("duplicate entry at row no " + rowNumber
								+ " in digibee excel sheet this sap-id is already present in the database");
						duplicateSapIdList.add(e.getSapId().toString());
						duplicateRow++;
						flag = false;
					}
				} else {
					errorsList.add("sap-id is null or improper in row no " + rowNumber + " in the digibee excel sheet");
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
			
			responseList.setTotal_No_Records(employeeDigiBeeList.size());
			responseList.setSucessful_Records(employeeDetailsList.size());
			responseList.setFailed_Records(employeeDigiBeeList.size()-employeeDetailsList.size());
			responseList.setDuplicate_Records(duplicateRow);
			responseList.setDuplicate_Sap_List(duplicateSapIdList);
			Map<String,List<String>> failed_Records_List=new HashMap<>();
			failed_Records_List.put("DigiBee", errorsList);
			responseList.setFailed_Records_List(failed_Records_List);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return responseList;
	}

	public List<EmployeeDetails> getAllEmployees() {
		return this.employeeDetailsRepository.findAll();
	}

	public List<Gender> getAllGender() {
		return this.genderRepository.findAll();
	}

	public Gender addGender(Gender gender) {
		return this.genderRepository.save(gender);

	}
}
