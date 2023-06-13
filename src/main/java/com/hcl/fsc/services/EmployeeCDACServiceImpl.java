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
import com.hcl.fsc.excel.vivo.CDAC;
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
import com.hcl.fsc.repositories.OnboardingStatusRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;
import com.hcl.fsc.repositories.UgDegreeRepository;

@Service
public class EmployeeCDACServiceImpl {
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private EmployeeEducationalDetailsRepository employeeEducationDetailsRepository;

	@Autowired
	private EmployeeOnboardingDetailsRepository employeeOnboardingRepository;

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
	private OnboardingStatusRepository onboardingStatusRepository;

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

	public ResponseList employeeCDACListSave(MultipartFile file) {

		List<String> errorsList = new ArrayList<>();
		ResponseList responseList = new ResponseList();
		List<String> duplicateSapIdList = new ArrayList<>();
		try {
			List<CDAC> employeeCDACList = EmployeeHelper.convertExcelToListOfCDAC(file.getInputStream());
			//System.out.println(employeeCDACList + " in CDAC Shhet");

			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();
			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();
			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

//			rowNumber = 2;
//			duplicateRow = 0;
			
			
			employeeCDACList.stream().forEach(e -> {
				boolean flag = true;
				if (e.getSapId() != null) {
					System.out.println(
							e.getSapId() + " checking sap-id " + employeeDetailsRepository.findById(e.getSapId()));
					if (employeeDetailsRepository.findById(e.getSapId()).equals(Optional.empty())) {
						if (!Constraints.nameValidate(e.getName())) {
							errorsList.add("Email Id is not Correct at " + rowNumber + " in digibee excel sheet");
							flag = true;
						}
						if (!Constraints.mobileNumberValidate(e.getContactNo())) {
							errorsList.add("Contact number is not Correct at " + rowNumber + " in digibee excel sheet");
							flag = true;
						}
						if (!Constraints.emailValidate(e.getEmail())) {
							errorsList.add("Email Id is not Correct at " + rowNumber + " in digibee excel sheet");
							flag = true;
						}
						if (genderRepository.findByValue(e.getGender().toLowerCase()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in gender column of CDAC excel sheet");
							flag = false;
						}
						if (regionRepository.findByValue(e.getRegion().toLowerCase()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in region column of CDAC excel sheet");
							flag = false;
						}
						if (stateRepository.findByValue(e.getState().toLowerCase()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in state column of CDAC excel sheet");
							flag = false;
						}
						if (ugDegreeRepository.findByValue(e.getUgDegree()) == null) {
							errorsList.add(
									"values are null or improper in row " + rowNumber + " in ug-degree column of CDAC excel sheet");
							flag = false;
						}
						if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-designation column of CDAC excel sheet");
							flag = false;
						}
						if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-band column of CDAC excel sheet");
							flag = false;
						}
						if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber
									+ " in offered-sub-band column of CDAC excel sheet");
							flag = false;
						}
						if (lobRepository.findByValue(e.getLob()) == null) {
							errorsList
									.add("values are null or improper in row " + rowNumber + " in lob column of CDAC excel sheet");
							flag = false;
						}
						if (l2Repository.findByValue(e.getL2()) == null) {
							errorsList.add("values are null or improper in row " + rowNumber + " in L2 column of CDAC excel sheet");
							flag = false;
						}
						if (flag == true) {
							EmployeeDetails employeeDetails = new EmployeeDetails();
							employeeDetails = modelMapper.map(e, EmployeeDetails.class);
							employeeDetails.setGender(genderRepository.findByValue(e.getGender().toLowerCase()));
							employeeDetails.setRegion(regionRepository.findByValue(e.getRegion().toLowerCase()));
							employeeDetails.setState(stateRepository.findByValue(e.getState().toLowerCase()));
							employeeDetails.setSheetCode("CDAC");
							employeeDetailsList.add(employeeDetails);

							EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();
							employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);
							// employeeEducationalDetails.setUgOrPG(ugOrPGRepository.findByValue(e.getUGOrPG()));
							// employeeEducationalDetails.setGraduationSpecialization(graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
							employeeEducationalDetails.setUgDegree(ugDegreeRepository.findByValue(e.getUgDegree()));
							employeeEducationalDetails.setSheetCode("CDAC");
							employeeEducationalDetailsList.add(employeeEducationalDetails);

							EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();
							employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);
//		    		employeeOnboardingDetails.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));
//		    		employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));
							employeeOnboardingDetails.setOnboardingStatus(
									onboardingStatusRepository.findByValue(e.getOnboardingStatus()));
							employeeOnboardingDetails.setOfferedDesignation(
									offeredDesignationRepository.findByValue(e.getOfferedDesignation()));
							employeeOnboardingDetails
									.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));
							employeeOnboardingDetails
									.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));
							employeeOnboardingDetails.setSheetCode("CDAC");
							employeeOnboardingDetailsList.add(employeeOnboardingDetails);

							EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();
							employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);
							employeeRecruitmentDetails.setLob(lobRepository.findByValue(e.getLob()));
							employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));
							employeeRecruitmentDetails.setSheetCode("CDAC");
							employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);
						}
					} else {
						errorsList.add("duplicate entry at row no " + rowNumber
								+ " in cdac excel sheet this sap-id is already present in the database");
						duplicateSapIdList.add(e.getSapId().toString());
						duplicateRow++;
						flag = false;
					}
				} else {
					errorsList.add("sap-id is null or improper in row no " + rowNumber + " in the cdac excel sheet");
				}
				rowNumber++;
			});

			//System.out.println(employeeDetailsList);
			employeeDetailsRepository.saveAll(employeeDetailsList);

			//System.out.println(employeeEducationalDetailsList);
			employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);

			//System.out.println(employeeRecruitmentDetailsList);
			employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);

			//System.out.println(employeeOnboardingDetailsList);
			employeeOnboardingRepository.saveAll(employeeOnboardingDetailsList);

			responseList.setTotal_No_Records(employeeCDACList.size());
			responseList.setSucessful_Records(employeeDetailsList.size());
			responseList.setFailed_Records(employeeCDACList.size() - employeeDetailsList.size());
			responseList.setDuplicate_Records(duplicateRow);
			responseList.setDuplicate_Sap_List(duplicateSapIdList);
			Map<String, List<String>> failed_Records_List = new HashMap<>();
			failed_Records_List.put("CDAC", errorsList);
			responseList.setFailed_Records_List(failed_Records_List);

			// res=1;
		} catch (Exception e) {
			e.printStackTrace();
//	 	System.out.println("some values are null calling from product service");
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
