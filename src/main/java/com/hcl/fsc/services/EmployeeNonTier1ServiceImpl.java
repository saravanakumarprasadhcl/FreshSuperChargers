package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.entities.EmployeeEducationalDetails;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.excel.vivo.NonTier1;
import com.hcl.fsc.helpers.EmployeeHelper;
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
import com.hcl.fsc.repositories.LOBRepository;
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;

@Service

public class EmployeeNonTier1ServiceImpl {

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

	private LOBRepository lobRepository;

	@Autowired

	private OfferedDesignationRepository offeredDesignationRepository;

	@Autowired

	private OfferedBandRepository offeredBandRepository;

	@Autowired

	private OfferedSubBandRepository offeredSubBandRepository;

	@Autowired

	private LocationRepository locationRepository;

	int count = 2;

	public List<String> employeeNonTier1ListSave(MultipartFile file) {

// int res = 0;

		List<String> errorsList = new ArrayList<>();

		try {

			List<NonTier1> employeeNonTier1List = EmployeeHelper.convertExcelToListOfNonTier1(file.getInputStream());

			System.out.println(employeeNonTier1List);

			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();

			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();

			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();

			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

//getting the data from NonTier1 and mapping it to employee details entity after validating the data from related master tables

			count = 2;

			employeeNonTier1List.stream().forEach(e -> {

				boolean flag = true;

				if (e.getSapId() != null) {

					System.out.println(

							e.getSapId() + " checking sap-id " + employeeDetailsRepository.findById(e.getSapId()));

					if (employeeDetailsRepository.findById(e.getSapId()).equals(Optional.empty())) {

						if (genderRepository.findByValue(e.getGender()) == null) {

							errorsList.add("values are null or improper in row " + count

									+ " in gender column of non-tier1 excel sheet");

							flag = false;

						}

						if (regionRepository.findByValue(e.getRegion()) == null) {

							errorsList.add("values are null or improper in row " + count

									+ " in region column of non-tier1 excel sheet");

							flag = false;

						}

						if (stateRepository.findByValue(e.getState()) == null) {

							errorsList.add("values are null or improper in row " + count

									+ " in state column of non-tier1 excel sheet");

							flag = false;

						}

						if (ugOrPGRepository.findByValue(e.getUgOrPg()) == null) {

							errorsList.add(

									"values are null in row " + count + " in ug-or-pg column of non-tier1 excel sheet");

							flag = false;

						}

						if (graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) == null) {

							errorsList.add("values are null in row " + count

									+ " in graduation-specialization column of non-tier1 excel sheet");

							flag = false;

						}

						if (locationRepository.findByValue(e.getLocation()) == null) {

							errorsList.add(

									"values are null in row " + count + " in location column of non-tier1 excel sheet");

							flag = false;

						}

						if (collegeTieringRepository.findByValue(e.getCollegeTiering()) == null) {

							errorsList.add("values are null in row " + count

									+ " in college-tiering column of non-tier1 excel sheet");

							flag = false;

						}

						if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {

							errorsList.add("values are null in row " + count

									+ " in offered-designation column of non-tier1 excel sheet");

							flag = false;

						}

						if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {

							errorsList.add("values are null in row " + count

									+ " in offered-band column of non-tier1 excel sheet");

							flag = false;

						}

						if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {

							errorsList.add("values are null in row " + count

									+ " in offered-sub-band column of non-tier1 excel sheet");

							flag = false;

						}

						if (l1Repository.findByValue(e.getL1()) == null) {

							errorsList

									.add("values are null in row " + count + " in L1 column of non-tier1 excel sheet");

							flag = false;

						}

						if (l2Repository.findByValue(e.getL2()) == null) {

							errorsList

									.add("values are null in row " + count + " in L2 column of non-tier1 excel sheet");

							flag = false;

						}

						if (l3Repository.findByValue(e.getL3()) == null) {

							errorsList

									.add("values are null in row " + count + " in L3 column of non-tier1 excel sheet");

							flag = false;

						}

						if (l4Repository.findByValue(e.getL4()) == null) {

							errorsList

									.add("values are null in row " + count + " in L4 column of non-tier1 excel sheet");

							flag = false;

						}

						if (flag) {

							EmployeeDetails employeeDetails = new EmployeeDetails();

							employeeDetails = modelMapper.map(e, EmployeeDetails.class);

							employeeDetails.setGender(genderRepository.findByValue(e.getGender()));

							employeeDetails.setRegion(regionRepository.findByValue(e.getRegion()));

							employeeDetails.setState(stateRepository.findByValue(e.getState()));

							employeeDetailsList.add(employeeDetails);

							EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();

							employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);

							employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));

							employeeEducationalDetails.setGraduationSpecialization(

									graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));

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

							employeeOnboardingDetailsList.add(employeeOnboardingDetails);

							EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();

							employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);

							employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));

							employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));

							employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));

							employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));

							employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

						}

					} else {

						errorsList.add("duplicate entry at row no " + count

								+ " in non-tier1 excel sheet this sap-id is already present in the database");

						flag = false;

					}

				} else {

					errorsList.add("sap-id is null or improper in row no " + count + " in the non-tier1 excel sheet");

				}

				count++;

			});

// System.out.println(employeeDetailsList);

			employeeDetailsRepository.saveAll(employeeDetailsList);

// System.out.println(employeeEducationalDetailsList);

			employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);

// System.out.println(employeeOnboardingDetailsList);

			employeeOnboardingDetailsRepository.saveAll(employeeOnboardingDetailsList);

// System.out.println(employeeRecruitmentDetailsList);

			employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);

//			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();

//			count = 2;

//			employeeNonTier1List.stream().forEach(e -> {

//				boolean flag = true;

//				if (ugOrPGRepository.findByValue(e.getUgOrPg()) == null) {

//					errorsList.add("values are null in row " + count + " in ug-or-pg column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) == null) {

//					errorsList.add("values are null in row " + count

//							+ " in graduation-specialization column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (flag == true) {

//					EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();

//					employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);

//					employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));

//					employeeEducationalDetails.setGraduationSpecialization(

//							graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));

//					employeeEducationalDetailsList.add(employeeEducationalDetails);

//				}

//

//				count++;

//

//			});

//			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();

//			count = 2;

//			employeeNonTier1List.stream().forEach(e -> {

//

//				boolean flag = true;

//				System.out.println(e.getLocation() + "--" + e.getCollegeTiering() + "--" + e.getOfferedBand() + "--"

//						+ e.getOfferedSubBand() + "--" + e.getOfferedDesignation());

//				if (locationRepository.findByValue(e.getLocation()) == null) {

//					errorsList.add("values are null in row " + count + " in location column of non-tier1 excel sheet");

//					flag = false;

//				}

//

//				if (collegeTieringRepository.findByValue(e.getCollegeTiering()) == null) {

//					errorsList.add(

//							"values are null in row " + count + " in college-tiering column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {

//					errorsList.add("values are null in row " + count

//							+ " in offered-designation column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {

//					errorsList.add(

//							"values are null in row " + count + " in offered-band column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {

//					errorsList.add(

//							"values are null in row " + count + " in offered-sub-band column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (flag == true) {

//					EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();

//					employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);

//					employeeOnboardingDetails

//							.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));

//					employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));

//					employeeOnboardingDetails

//							.setOfferedDesignation(offeredDesignationRepository.findByValue(e.getOfferedDesignation()));

//					employeeOnboardingDetails.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));

//					employeeOnboardingDetails

//							.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));

//					employeeOnboardingDetailsList.add(employeeOnboardingDetails);

//				}

//

//				count++;

//

//			});

////

//			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

//			count = 2;

//

//			employeeNonTier1List.stream().forEach(e -> {

//				boolean flag = true;

//				System.out.println(e.getL1() + "--" + e.getL2() + "--" + e.getL3() + "--" + e.getL4());

//				if (l1Repository.findByValue(e.getL1()) == null) {

//					errorsList.add("values are null in row " + count + " in L1 column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (l2Repository.findByValue(e.getL2()) == null) {

//					errorsList.add("values are null in row " + count + " in L2 column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (l3Repository.findByValue(e.getL3()) == null) {

//					errorsList.add("values are null in row " + count + " in L3 column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (l4Repository.findByValue(e.getL4()) == null) {

//					errorsList.add("values are null in row " + count + " in L4 column of non-tier1 excel sheet");

//					flag = false;

//				}

//				if (flag == true) {

//					EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();

//					employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);

//					employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));

//					employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));

//					employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));

//					employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));

//					employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

//				}

//

//				count++;

//			});

//

// res = 1;

		} catch (Exception e) {

			e.printStackTrace();

//	 	System.out.println("some values are null calling from product service");

		}

		return errorsList;

	}

	public List<EmployeeDetails> getAllEmployees() {

		return this.employeeDetailsRepository.findAll();

	}

}