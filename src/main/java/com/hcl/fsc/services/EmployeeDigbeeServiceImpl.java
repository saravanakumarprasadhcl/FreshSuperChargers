package com.hcl.fsc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.Digibee;
import com.hcl.fsc.entities.NonTier_1;
import com.hcl.fsc.excel.vivo.EmployeeDetails;
import com.hcl.fsc.excel.vivo.EmployeeEducationalDetails;
import com.hcl.fsc.excel.vivo.EmployeeOnboardingDetails;
import com.hcl.fsc.excel.vivo.EmployeeRecruitmentDetails;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.EmployeeEducationDetailsRepository;
import com.hcl.fsc.repositories.EmployeeNonTier1Repository;
import com.hcl.fsc.repositories.EmployeeOnboardingRepository;
import com.hcl.fsc.repositories.EmployeeRecruitmentDetailsRepository;
import com.hcl.fsc.repositories.GenderRepository;

public class EmployeeDigbeeServiceImpl {
	@Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    
    @Autowired
    private EmployeeEducationDetailsRepository employeeEducationDetailsRepository;
    
    @Autowired
    private EmployeeOnboardingRepository employeeOnboardingRepository;
    
    @Autowired
    private EmployeeRecruitmentDetailsRepository employeeRecruitmentDetailsRepository;
    
//    @Autowired
//    private EmployeeNonTier1Repository employeeNonTier1Repository;
    
    @Autowired
	private ModelMapper modelMapper;
    
    @Autowired
    private GenderRepository genderRepository;
    
	public int employeeNonTier1ListSave(MultipartFile file) {
		int res=0;
		try {
			List<Digibee> employeeDigiBeeList = EmployeeHelper.convertExcelToListOfDigibee(file.getInputStream());
			System.out.println(employeeDigiBeeList.size()+"size of list");
			//employeeNonTier1Repository.saveAll(employeeNonTier1List);	
			
			
			List<EmployeeDetails> employeeDetailsList=employeeDigiBeeList.stream()
					.map(employeeDetails-> modelMapper.map(employeeDetails,EmployeeDetails.class))
					.collect(Collectors.toList());	
			
//			for(int i=0; i<employeeDigiBeeList.size(); i++) {
//				employeeDetailsList.get(i).setGender(genderRepository.findByGenderValue(employeeDigiBeeList.get(i).getGender().toLowerCase()));	
//			}
			
			System.out.println(employeeDetailsList);						
            employeeDetailsRepository.saveAll(employeeDetailsList);
            
            List<EmployeeEducationalDetails> employeeEducationalDetailsList=employeeDigiBeeList.stream().map(employeeEducationalDetails-> modelMapper.map(employeeEducationalDetails,EmployeeEducationalDetails.class)).collect(Collectors.toList());			    			
            System.out.println(employeeEducationalDetailsList);
            employeeEducationDetailsRepository.saveAll(employeeEducationalDetailsList);
            
            List<EmployeeOnboardingDetails> employeeOnboardingDetailsList =employeeDigiBeeList.stream().map(employeeOnboardingDetails-> modelMapper.map(employeeOnboardingDetails,EmployeeOnboardingDetails.class)).collect(Collectors.toList());			    			
            System.out.println(employeeOnboardingDetailsList);
            employeeOnboardingRepository.saveAll(employeeOnboardingDetailsList);
            
            List<EmployeeRecruitmentDetails> employeeRecruitmentDetailsList =employeeDigiBeeList.stream().map(employeeRecruitmentDetails-> modelMapper.map(employeeRecruitmentDetails,EmployeeRecruitmentDetails.class)).collect(Collectors.toList());			    			
            System.out.println(employeeRecruitmentDetailsList);
            employeeRecruitmentDetailsRepository.saveAll(employeeRecruitmentDetailsList);
            
			res=1;		
		}catch(Exception e) {
			e.printStackTrace();
//	 	System.out.println("some values are null calling from product service");
		} return res;
	}

	public List<EmployeeDetails> getAllEmployees(){
		return this.employeeDetailsRepository.findAll();
	}
//	public List<NonTier_1> getAllNonTier1Employees() {		
//		return this.employeeNonTier1Repository.findAll();
//	} 
	public List<Gender> getAllGender(){
		return this.genderRepository.findAll();
	}
	public Gender addGender(Gender gender) {
		return this.genderRepository.save(gender);
		
	}
}