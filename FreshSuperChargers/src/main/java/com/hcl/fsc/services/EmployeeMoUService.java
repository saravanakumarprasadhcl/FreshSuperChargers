package com.hcl.fsc.services;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.hcl.fsc.excel.vivo.MoU;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationalDetailsRepository;
import com.hcl.fsc.repositories.EmployeeOnboardingDetailsRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;

@Service
public class EmployeeMoUService {

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

//	private static List<String> logs;

	public void save(MultipartFile file) {
		try {
			List<MoU> list = EmployeeHelper.convertExcelToMoU(file.getInputStream());
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//			int count = 0;
//
//			Iterator<MoU> mouItr = list.iterator();
//			logs = new ArrayList<>();
//			boolean flag = false;
//			while (mouItr.hasNext()) {
//				MoU mou = mouItr.next();
//				count++;
//				if (!Constraints.mobileNumberValidate(mou.getContact())) {
//					logs.add("Contact number is not Correct at " + count + " row");
//					flag = true;
//				}
//				if (!Constraints.emialValidate(mou.getEmail())) {
//					logs.add("Email Id is not Correct at " + count + " row");
//					flag = true;
//				}
//				if(flag) {
//					mouItr.remove();
//				}
//			}
//			logs.add("Total row Issues : "+count);
			
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

//	public static List<String> getLogs() {
//		return logs;
//	}

}
