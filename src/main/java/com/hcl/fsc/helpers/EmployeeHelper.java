package com.hcl.fsc.helpers;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.excel.vivo.MoU;
import com.hcl.fsc.excel.vivo.SkilledHiring;
import com.hcl.fsc.excel.vivo.Tier1;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

public class EmployeeHelper {

	public static boolean checkExcelFormate(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		else
			return false;
	}

	public static List<Tier1> convertExcelToTier1(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<Tier1> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, Tier1.class, options);
		return list;
	}
	
	public static List<SkilledHiring> convertExcelToSkilledHiring(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<SkilledHiring> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, SkilledHiring.class);
		return list;
	}
	
	public static List<MoU> convertExcelToMoU(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<MoU> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, MoU.class);
		return list;
	}

	
	
}
