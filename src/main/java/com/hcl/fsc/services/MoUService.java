package com.hcl.fsc.services;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fcs.poijo.MoU;
import com.hcl.fsc.entities.EmployeeDetails;
import com.hcl.fsc.entities.EmployeeEducationDetails;
import com.hcl.fsc.entities.EmployeeOnboardingDetails;
import com.hcl.fsc.entities.EmployeeRecruitmentDetails;
import com.hcl.fsc.helpers.Helper;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationDetailsRepository;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;

@Service
public class MoUService {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private EmployeeEducationDetailsRepository employeeEducationDetailsRepository;

	@Autowired
	private EmployeeOnboardingDetailsRepository employeeOnboardingDetailsRepository;

	@Autowired
	private EmployeeRecruitmentDetailsRepository employeeRecruitmentDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;


	public void save(MultipartFile file) {
		try {
			List<MoU> list = Helper.convertExcelToMoU(file.getInputStream());

			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

			
			List<EmployeeDetails> employeeDetailsList = list.stream()
					.map(employeeDetails -> modelMapper.map(employeeDetails, EmployeeDetails.class))
					.collect(Collectors.toList());
			
			employeeDetailsRepository.saveAll(employeeDetailsList);

			List<EmployeeEducationDetails> employeeducationDetailsList = list.stream()
					.map(employeeEducationDetails -> modelMapper.map(employeeEducationDetails,
							EmployeeEducationDetails.class))
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
