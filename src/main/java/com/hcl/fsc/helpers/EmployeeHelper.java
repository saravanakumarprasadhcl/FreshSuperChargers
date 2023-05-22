package com.hcl.fsc.helpers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.CDAC;
import com.hcl.fsc.entities.Digibee;
import com.hcl.fsc.entities.NonTier_1;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

public class EmployeeHelper {
	public static boolean checkExcelFormate(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		else
			return false;
	}

	public static List<NonTier_1> convertExcelToListOfNonTier1(InputStream inputStream) {
		
		List<NonTier_1> employeeNonTier1List= new ArrayList<>();
			PoijiExcelType excelType = PoijiExcelType.XLSX;
			employeeNonTier1List=Poiji.fromExcel(inputStream, excelType, NonTier_1.class);
			System.out.println(employeeNonTier1List);
		return employeeNonTier1List;

   }
public static List<Digibee> convertExcelToListOfDigibee(InputStream inputStream) {
		
		List<Digibee> employeeDigibeeList= new ArrayList<>();
			PoijiExcelType excelType = PoijiExcelType.XLSX;
			employeeDigibeeList=Poiji.fromExcel(inputStream, excelType, Digibee.class);
		return employeeDigibeeList;

   }
public static List<CDAC> convertExcelToListOfCDAC(InputStream inputStream) {
	
	List<CDAC> employeeCDACList= new ArrayList<>();
		PoijiExcelType excelType = PoijiExcelType.XLSX;
		employeeCDACList=Poiji.fromExcel(inputStream, excelType, CDAC.class);
	return employeeCDACList;

}
}
