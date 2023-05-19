package com.hcl.fsc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.hcl.fsc.entities.Candidate;
import com.hcl.fsc.helpers.CandidateHelper;
import com.hcl.fsc.repositories.CandidateRepository;


@Service
public class CandidateServiceImpl {
	
    @Autowired
    private CandidateRepository candidateRepository;

 //static int rowTotal;
//	List<Product> products;
	public int save(MultipartFile file) {
		int res=0;
		try {
			List<Candidate> products = CandidateHelper.convertExcelToListOfProduct(file.getInputStream());
			System.out.println(products.size()+"size of list");
//			System.out.println(products);
			//if(products.size()!=0) {
			candidateRepository.saveAll(products);
			res=1;
			//}
//			InputStream is=file.getInputStream();
//			XSSFWorkbook workbook = new XSSFWorkbook(is);
//			XSSFSheet sheet = workbook.getSheet("data");
//           
//			 rowTotal = sheet.getLastRowNum();
//			System.out.println("no of rows "+rowTotal);
//			if(rowTotal==products.size())
//				res=1;
//			else
//				res=-1;
			
		}catch(Exception e) {
		System.out.println("some values are null calling from product service");
		} return res;
	}
//	public int getStatus() {
//		if(rowTotal==products.size())
//		return -1;
//		else
//			return products.size()+1;
//	}
	public List<Candidate> getAllCandidates(){
		return this.candidateRepository.findAll();
	}
}
