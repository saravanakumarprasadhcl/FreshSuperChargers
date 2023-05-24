package com.hcl.fsc.helpers;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.fcs.poijo.MoU;
import com.hcl.fcs.poijo.SkilledHiring;
import com.hcl.fcs.poijo.Tier_1;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

public class Helper {

	public static boolean checkExcelFormate(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		else
			return false;
	}

	public static List<Tier_1> convertExcelToTier1(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<Tier_1> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, Tier_1.class, options);
		return list;
	}
	
	public static List<SkilledHiring> convertExcelToSkilledHiring(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<SkilledHiring> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, SkilledHiring.class);
		System.out.println("---------------------------------------");
		System.out.println(list.get(0).getUniversityRegistrationId());
		System.out.println("---------------------------------------");
		return list;
	}
	
	public static List<MoU> convertExcelToMoU(InputStream is) {
		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true).build();
		List<MoU> list = Poiji.fromExcel(is, PoijiExcelType.XLSX, MoU.class);
		System.out.println("---------------------------------------");
		System.out.println(list.size());
		System.out.println("---------------------------------------");
		return list;
	}

	
	
}
