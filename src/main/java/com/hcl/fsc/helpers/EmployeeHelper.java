package com.hcl.fsc.helpers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.excel.vivo.CDAC;
import com.hcl.fsc.excel.vivo.DigiBee;
import com.hcl.fsc.excel.vivo.NonTier1;
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

	public static List<NonTier1> convertExcelToListOfNonTier1(InputStream inputStream) {
		
		List<NonTier1> employeeNonTier1List= new ArrayList<>();
			PoijiExcelType excelType = PoijiExcelType.XLSX;
			employeeNonTier1List=Poiji.fromExcel(inputStream, excelType, NonTier1.class);
			
		return employeeNonTier1List;

   }
public static List<DigiBee> convertExcelToListOfDigibee(InputStream inputStream) {
		
		List<DigiBee> employeeDigibeeList= new ArrayList<>();
			PoijiExcelType excelType = PoijiExcelType.XLSX;
			employeeDigibeeList=Poiji.fromExcel(inputStream, excelType, DigiBee.class);
		return employeeDigibeeList;

   }
public static List<CDAC> convertExcelToListOfCDAC(InputStream inputStream) {
	
	List<CDAC> employeeCDACList= new ArrayList<>();
		PoijiExcelType excelType = PoijiExcelType.XLSX;
		employeeCDACList=Poiji.fromExcel(inputStream, excelType, CDAC.class);
	return employeeCDACList;

}
}
