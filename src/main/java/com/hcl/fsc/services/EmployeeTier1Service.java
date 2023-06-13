package com.hcl.fsc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.entities.EmployeeEducationalDetails;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.excel.vivo.Tier1;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationalDetailsRepository;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;

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

	public void save(MultipartFile file) {
		try {
			List<Tier1> list = EmployeeHelper.convertExcelToTier1(file.getInputStream());

			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

			List<EmployeeDetails> employeeDetailsList = list.stream()
					.map(employeeDetails -> modelMapper.map(employeeDetails, EmployeeDetails.class))
					.collect(Collectors.toList());
			employeeDetailsRepository.saveAll(employeeDetailsList);

			List<EmployeeEducationalDetails> employeeducationDetailsList = list.stream()
					.map(employeeEducationDetails -> modelMapper.map(employeeEducationDetails,
							EmployeeEducationalDetails.class))
					.collect(Collectors.toList());
			employeeEducationDetailsRepository.saveAll(employeeducationDetailsList);

			List<EmployeeOnboardingDetails> onboardingDetailsList = list.stream()
					.map(employee -> modelMapper.map(employee, EmployeeOnboardingDetails.class))
					.collect(Collectors.toList());
			employeeOnboardingDetailsRepository.saveAll(onboardingDetailsList);

			List<EmployeeRecruitmentDetails> recruitmentDetailsList = list.stream()
					.map(employee -> modelMapper.map(employee, EmployeeRecruitmentDetails.class))
					.collect(Collectors.toList());
			employeeRecruitmentDetailsRepository.saveAll(recruitmentDetailsList);

		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
