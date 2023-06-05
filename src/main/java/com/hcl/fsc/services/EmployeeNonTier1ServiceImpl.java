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
import com.hcl.fsc.repositories.LobRepository;
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
	private LobRepository lobRepository;

	@Autowired
	private OfferedDesignationRepository offeredDesignationRepository;

	@Autowired
	private OfferedBandRepository offeredBandRepository;

	@Autowired
	private OfferedSubBandRepository offeredSubBandRepository;

	@Autowired
	private LocationRepository locationRepository;

	public int employeeNonTier1ListSave(MultipartFile file) {
		int res = 0;
		try {
			List<NonTier1> employeeNonTier1List = EmployeeHelper.convertExcelToListOfNonTier1(file.getInputStream());
			System.out.println(employeeNonTier1List);
			List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
//getting the data from NonTier1 and mapping it to employee details entity after validating the data from related master tables
			employeeNonTier1List.stream().forEach(e -> {
				if (genderRepository.findByValue(e.getGender()) != null
						&& regionRepository.findByValue(e.getRegion()) != null
						&& stateRepository.findByValue(e.getState()) != null) {
					EmployeeDetails employeeDetails = new EmployeeDetails();
					employeeDetails = modelMapper.map(e, EmployeeDetails.class);
					employeeDetails.setGender(genderRepository.findByValue(e.getGender()));
					employeeDetails.setRegion(regionRepository.findByValue(e.getRegion()));
					employeeDetails.setState(stateRepository.findByValue(e.getState()));
					employeeDetailsList.add(employeeDetails);

				}

			});

			// System.out.println(employeeDetailsList);
			employeeDetailsRepository.saveAll(employeeDetailsList);
			List<EmployeeEducationalDetails> employeeEducationalDetailsList = new ArrayList<>();
			employeeNonTier1List.stream().forEach(e -> {
				if (ugOrPGRepository.findByValue(e.getUgOrPg()) != null
						&& graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()) != null) {
					EmployeeEducationalDetails employeeEducationalDetails = new EmployeeEducationalDetails();
					employeeEducationalDetails = modelMapper.map(e, EmployeeEducationalDetails.class);
					employeeEducationalDetails.setUgOrPg(ugOrPGRepository.findByValue(e.getUgOrPg()));
					employeeEducationalDetails.setGraduationSpecialization(
							graduationSpecializationRepository.findByValue(e.getGraduationSpecialization()));
					employeeEducationalDetailsList.add(employeeEducationalDetails);
				}
			});
			// System.out.println(employeeEducationalDetailsList);
			employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);

			List<EmployeeOnboardingDetails> employeeOnboardingDetailsList = new ArrayList<>();
			employeeNonTier1List.stream().forEach(e -> {
				System.out.println(e.getLocation() + "--" + e.getCollegeTiering() + "--" + e.getOfferedBand() + "--"
						+ e.getOfferedSubBand() + "--" + e.getOfferedDesignation());
				if (locationRepository.findByValue(e.getLocation()) != null
						&& collegeTieringRepository.findByValue(e.getCollegeTiering()) != null
						&& offeredDesignationRepository.findByValue(e.getOfferedDesignation()) != null
						&& offeredBandRepository.findByValue(e.getOfferedBand()) != null
						&& offeredSubBandRepository.findByValue(e.getOfferedSubBand()) != null) {
					EmployeeOnboardingDetails employeeOnboardingDetails = new EmployeeOnboardingDetails();
					employeeOnboardingDetails = modelMapper.map(e, EmployeeOnboardingDetails.class);
					employeeOnboardingDetails
							.setCollegeTiering(collegeTieringRepository.findByValue(e.getCollegeTiering()));
					employeeOnboardingDetails.setLocation(locationRepository.findByValue(e.getLocation()));
					employeeOnboardingDetails
							.setOfferedDesignation(offeredDesignationRepository.findByValue(e.getOfferedDesignation()));
					employeeOnboardingDetails.setOfferedBand(offeredBandRepository.findByValue(e.getOfferedBand()));
					employeeOnboardingDetails
							.setOfferedSubBand(offeredSubBandRepository.findByValue(e.getOfferedSubBand()));
					employeeOnboardingDetailsList.add(employeeOnboardingDetails);
				}
			});
////            System.out.println(employeeOnboardingDetailsList);
			employeeOnboardingDetailsRepository.saveAll(employeeOnboardingDetailsList);

//			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = employeeNonTier1List.stream()
//					.map(employeeRecruitmentDetails -> modelMapper.map(employeeRecruitmentDetails,
//							EmployeeRecruitmentDetails.class))
//					.collect(Collectors.toList());
			List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList = new ArrayList<>();
			employeeNonTier1List.stream().forEach(e -> {
				System.out.println(e.getL1() + "--" + e.getL2() + "--" + e.getL3() + "--" + e.getL4());
				if (l1Repository.findByValue(e.getL1()) != null && l2Repository.findByValue(e.getL2()) != null
						&& l3Repository.findByValue(e.getL3()) != null && l4Repository.findByValue(e.getL4()) != null) {
					EmployeeRecruitmentDetails employeeRecruitmentDetails = new EmployeeRecruitmentDetails();
					employeeRecruitmentDetails = modelMapper.map(e, EmployeeRecruitmentDetails.class);
					employeeRecruitmentDetails.setL1(l1Repository.findByValue(e.getL1()));
					employeeRecruitmentDetails.setL2(l2Repository.findByValue(e.getL2()));
					employeeRecruitmentDetails.setL3(l3Repository.findByValue(e.getL3()));
					employeeRecruitmentDetails.setL4(l4Repository.findByValue(e.getL4()));
					employeeRecruitmentDetailsList.add(employeeRecruitmentDetails);
				}
			});
//            System.out.println(employeeRecruitmentDetailsList);
			employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);

			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
//	 	System.out.println("some values are null calling from product service");
		}
		return res;
	}

	public List<EmployeeDetails> getAllEmployees() {
		return this.employeeDetailsRepository.findAll();
	}

}
