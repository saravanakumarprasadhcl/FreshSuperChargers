package com.hcl.fsc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.Employee;
import com.hcl.fsc.helpers.EmployeeHelper;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.Lob;
import com.hcl.fsc.repositories.EmployeeRepository;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.LobRepository;


@Service
public class EmployeeServiceImpl {
	
    @Autowired
    private EmployeeRepository candidateRepository;
    
    @Autowired
    private GenderRepository genderRepository;
    
    @Autowired
    private LobRepository lobRepository;


 //static int rowTotal;
//	List<Product> products;
	public int save(MultipartFile file) {
		int res=0;
//		try {
//			List<Candidate> products = CandidateHelper.convertExcelToListOfProduct(file.getInputStream());
//			System.out.println(products.size()+"size of list");
////			System.out.println(products);
//			//if(products.size()!=0) {
//			candidateRepository.saveAll(products);
//			res=1;
//			//}
////			InputStream is=file.getInputStream();
////			XSSFWorkbook workbook = new XSSFWorkbook(is);
////			XSSFSheet sheet = workbook.getSheet("data");
////           
////			 rowTotal = sheet.getLastRowNum();
////			System.out.println("no of rows "+rowTotal);
////			if(rowTotal==products.size())
////				res=1;
////			else
////				res=-1;
//			
//		}catch(Exception e) {
//		System.out.println("some values are null calling from product service");
//		} 
		return res;
	}
//	public int getStatus() {
//		if(rowTotal==products.size())
//		return -1;
//		else
//			return products.size()+1;
//	}
	public List<Employee> getAllCandidates(){
		return this.candidateRepository.findAll();
	}
	
	public List<Gender> getAllGender(){
		return this.genderRepository.findAll();
    }
	public List<Lob> getAllLob(){
		return this.lobRepository.findAll();
    }
    public Gender addGender(Gender gender) {
		return genderRepository.save(gender);

    }
	public void updateGender(String genderkey, Gender gender) {
		Gender g=genderRepository.getById(genderkey);		
		g.setGENDERVALUE(gender.getGENDERVALUE());
		genderRepository.save(g);
//        	System.out.println(g+"---"+gender);
//		long val = g.getUID();
////		System.out.println(g+"new one");
//		gender.setUID(val);
//		System.out.println("-----------------------------------");
//		System.out.println(g.getGENDERKEY());
//		System.out.println(g.getGENDERVALUE());
//		System.out.println(g.getUID());
//		System.out.println("-----------------------------------");
//		g.setGENDERKEY(gender.getGENDERKEY());
//		g.setUID(gender.getUID());
//		g.setUID(g.getUID());
//		System.out.println("-----------------------------------");
//		System.out.println(g.getGENDERKEY());
//		System.out.println(g.getGENDERVALUE());
//		System.out.println(g.getUID());
//		System.out.println("-----------------------------------");
//		return genderRepository.save(gender);
		
//		Gender g = genderRepository.getById(genderkey);
//		genderRepository.deleteById(g.getGENDERKEY());
//		g.setUID(g.getUID());
//		Gender gen = new Gender(g.getUID(), gender.getGENDERKEY(), gender.getGENDERVALUE());
//		genderRepository.save(gen);
	}
	public void deleteGender(String genderkey) {
		genderRepository.deleteById(genderkey);
	}
	
	
	public Gender getbyGenderkey(String genderkey) {
		return this.genderRepository.findByGENDERKEY(genderkey);
	}
}
