package com.fis.lip;

import java.util.List;

import com.fis.lip.beans.TourPackage;
import com.fis.lip.business.TourPackageMgr;

public class TestMetaData {

	public static void main(String[] args) throws Exception {
		String source = "MOHALI";
		String dest = "GOA";
		String packageId = "1234567";
		double baseFare = 0;
		TourPackage tp = new TourPackage();
		tp.setPackageId(packageId);
		tp.setSource(source);
		tp.setDest(dest);
		tp.setBaseFare(baseFare);
		TourPackageMgr mgr = new TourPackageMgr();
		boolean isAdded = mgr.addPackage(tp);
		System.out.println("Is added.." + isAdded);

		List<TourPackage> list = mgr.getAllPackages();
		System.out.println("List of all available packages:");
		for (TourPackage tourPackage : list) {
			System.out.println(tourPackage);
		}
		System.out.println("\n- - - - - - -");

	}

}
