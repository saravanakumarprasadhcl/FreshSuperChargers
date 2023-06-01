package com.hcl.fsc.helpers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.entities.Employee;


public class EmployeeHelper {
	public static boolean checkExcelFormate(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		else
			return false;
	}

//	public static List<Candidate> convertExcelToListOfProduct(InputStream is) {

//		List<Candidate> candidateList = new ArrayList<>();
//        int c=0;
//		try {
//			XSSFWorkbook workbook = new XSSFWorkbook(is);
//			XSSFSheet sheet = workbook.getSheet("data");
//			int rowNumber = 0;
//			Iterator<Row> iterator = sheet.iterator();
//
//			while (iterator.hasNext()) {
//				Row row = iterator.next();
//				c++;
//				if (rowNumber == 0) {
//					System.out.println(row.getCell(1));
//					rowNumber++;
//					continue;
//				}
//				Iterator<Cell> cells = row.iterator();
//				int cid = 0;
//				Candidate candidate = new Candidate();
//            
//				while (cells.hasNext()) {
//					Cell cell = cells.next();
//					if(cid!=cell.getColumnIndex()) {
//                    candidate.setGender("m");
//					}
//					switch (cid) {
//					
//					case 0:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setSapId(1000);
//							}
//						else
//							candidate.setSapId((int) (cell.getNumericCellValue()));
//						break;
//					case 1:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setName("name");
//						}else
//							candidate.setName(cell.getStringCellValue());
//						
//						break;
//					case 2:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {	
//							candidate.setGender("gender");
//						}
//						else
//							candidate.setGender(cell.getStringCellValue());
//						break;
//					case 3:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setEmail("email");
//						}
//						else
//							candidate.setEmail(cell.getStringCellValue());
//						break;
//					case 4:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setContactNo(011);
//						}
//						else
//						candidate.setContactNo((long)cell.getNumericCellValue());
//						break;
//					case 5:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setAlternateContactNo(022);	
//						}else
//							candidate.setAlternateContactNo((long)cell.getNumericCellValue());
//						break;
//					case 6:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setState("state");
//						}
//						else
//							candidate.setState(cell.getStringCellValue());
//						break;
//					case 7:
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						if (cell == null || cell.getCellType() == CellType.BLANK) {
//							candidate.setAddress("address");
//						}
//						else
//							candidate.setAddress(cell.getStringCellValue());
//						break;
//					case 8:
//						System.out.println("start 8th cell");
//						System.out.println(cell.getColumnIndex()+"--"+cell.getCellType()+"--"+cell.toString()+"--"+cid);
//						System.out.println("start 8th cell");
//						if (cell == null || cell.getCellType() == CellType.BLANK ) {
//							candidate.setRegion("region");
//						}
//						else
//							candidate.setRegion(cell.getStringCellValue());
//						break;
//					default:
//						break;
//					}
//					cid++;
//				}
//				System.out.println(candidate.toString());
//				candidateList.add(candidate);
//			}
//
//		}
//		catch (Exception e) {
//		System.out.println("Row "+(c-1)+" has some values are null or maybe not proper calling from helper");
//		} 
//		return candidateList;
//	}
//	
}
