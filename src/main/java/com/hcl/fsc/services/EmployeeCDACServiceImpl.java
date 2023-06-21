package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.List;

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
import com.hcl.fsc.repositories.LOBRepository;
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGDegreeRepository;
import com.hcl.fsc.repositories.UGOrPGRepository;

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

	private UGDegreeRepository ugDegreeRepository;

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

	public List<String> employeeCDACListSave(MultipartFile file) {

// int res=0;

		List<String> errorsList = new ArrayList<>();

		try {

			List<CDAC> employeeCDACList = EmployeeHelper.convertExcelToListOfCDAC(file.getInputStream());

			System.out.println(employeeCDACList + " in CDAC Shhet");

			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();

			count = 2;

			employeeCDACList.stream().forEach(e -> {

				boolean flag = true;

				if (genderRepository.findByValue(e.getGender().toLowerCase()) == null) {

					errorsList.add("values are null in row " + count + " in gender column of CDAC excel sheet");

					flag = false;

				}

				if (regionRepository.findByValue(e.getRegion().toLowerCase()) == null) {

					errorsList.add("values are null in row " + count + " in region column of CDAC excel sheet");

					flag = false;

				}

				if (stateRepository.findByValue(e.getState().toLowerCase()) == null) {

					errorsList.add("values are null in row " + count + " in state column of CDAC excel sheet");

					flag = false;

				}

				if (flag) {

					EmployeeDetails employeeDetails = new EmployeeDetails();

					employeeDetails = modelMapper.map(e, EmployeeDetails.class);

					employeeDetails.setGender(genderRepository.findByValue(e.getGender().toLowerCase()));

					employeeDetails.setRegion(regionRepository.findByValue(e.getRegion().toLowerCase()));

					employeeDetails.setState(stateRepository.findByValue(e.getState().toLowerCase()));

					employeeDetailsList.add(employeeDetails);

				}

				count++;

			});

			System.out.println(employeeDetailsList);

			employeeDetailsRepository.saveAll(employeeDetailsList);

			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();

			count = 2;

			employeeCDACList.stream().forEach(e -> {

				boolean flag = true;

// System.out.println(e.getUgDegree()+"---"+ugDegreeRepository.findByValue(e.getUgDegree()));

				if (ugDegreeRepository.findByValue(e.getUgDegree()) == null) {

					errorsList.add("values are null in row " + count + " in ug-degree column of CDAC excel sheet");

					flag = false;

				}

				if (flag) {

					EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();

					employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);

// employeeEducationalDetails.setUgOrPG(ugOrPGRepository.findByValue(e.getUGOrPG()));

// employeeEducationalDetails.setGraduationSpecialization(graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));

					employeeEducationalDetails.setUgDegree(ugDegreeRepository.findByValue(e.getUgDegree()));

					employeeEducationalDetailsList.add(employeeEducationalDetails);

				}

				count++;

			});

			System.out.println(employeeEducationalDetailsList);

			employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);

			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();

			count = 2;

			employeeCDACList.stream().forEach(e -> {

				boolean flag = true;

// System.out.println(e.getLocation()+"--"+e.getCollegeTiering()+"--"+e.getOfferedBand()+"--"+e.getOfferedSubBand()+"--"+e.getOfferedDesignation());

				if (offeredDesignationRepository.findByValue(e.getOfferedDesignation()) == null) {

					errorsList.add(

							"values are null in row " + count + " in offered-designation column of CDAC excel sheet");

					flag = false;

				}

				if (offeredBandRepository.findByValue(e.getOfferedBand()) == null) {

					errorsList.add("values are null in row " + count + " in offered-band column of CDAC excel sheet");

					flag = false;

				}

				if (offeredSubBandRepository.findByValue(e.getOfferedSubBand()) == null) {

					errorsList

							.add("values are null in row " + count + " in offered-sub-band column of CDAC excel sheet");

					flag = false;

				}

				if (flag) {

					EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();

					employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);

//		    		employeeOnboardingDetails.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));

//		    		employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));

					employeeOnboardingDetails

							.setOfferedDesignation(offeredDesignationRepository.findByValue(e.getOfferedDesignation()));

					employeeOnboardingDetails.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));

					employeeOnboardingDetails

							.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));

					employeeOnboardingDetailsList.add(employeeOnboardingDetails);

				}

				count++;

			});

			System.out.println(employeeOnboardingDetailsList);

			employeeOnboardingRepository.saveAll(employeeOnboardingDetailsList);

			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();

			count = 2;

			employeeCDACList.stream().forEach(e -> {

				boolean flag = true;

				System.out.println(e.getLob() + "--" + e.getL2());

				if (lobRepository.findByValue(e.getLob()) == null) {

					errorsList.add("values are null in row " + count + " in lob column of CDAC excel sheet");

					flag = false;

				}

				if (l2Repository.findByValue(e.getL2()) == null) {

					errorsList.add("values are null in row " + count + " in L2 column of CDAC excel sheet");

					flag = false;

				}

				if (flag) {

					EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();

					employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);

					employeeRecruitmentDetails.setLob(lobRepository.findByValue(e.getLob()));

					employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));

					employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);

				}

				count++;

			});

			System.out.println(employeeRecruitmentDetailsList);

			employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);

// res=1;

		} catch (Exception e) {

			e.printStackTrace();

//	 	System.out.println("some values are null calling from product service");

		}

		return errorsList;

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