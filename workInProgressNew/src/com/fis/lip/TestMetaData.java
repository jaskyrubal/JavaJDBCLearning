package com.fis.lip;

import java.util.List;
import java.util.Scanner;

import com.fis.lip.beans.TourPackage;
import com.fis.lip.business.TourPackageMgr;

public class TestMetaData {

	public static void main(String[] args) throws Exception {
		try {
			System.out.println("You are now going to a new package!");
			System.out.println("Enter Details for Package you want to Insert...");
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter the Source location:");
				String source = sc.next();
				System.out.println("Enter the Destination location:");
				String dest = sc.next();
				System.out.println("Enter the PackageID:");
				String packageId = sc.next();
				System.out.println("Enter the Base Fare:");
				double baseFare = sc.nextDouble();
				//String source = "MOHALI";
				//String dest = "GOA";
				//String packageId = "1234567";
				//double baseFare = 0;
				TourPackage tp = new TourPackage();
				tp.setPackageId(packageId);
				tp.setSource(source);
				tp.setDest(dest);
				tp.setBaseFare(baseFare);
				TourPackageMgr mgr = new TourPackageMgr();
				boolean isAdded = mgr.addPackage(tp);
				System.out.println("Is added..");

				List<TourPackage> list = mgr.getAllPackages();
				System.out.println("List of all available packages:");
				for (TourPackage tourPackage : list) {
					System.out.println(tourPackage);
				}
			}
			System.out.println("\n- - - - - - -");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
