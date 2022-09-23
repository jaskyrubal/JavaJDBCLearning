package com.fis.lip;

import java.util.List;
import java.util.Scanner;

import com.fis.lip.beans.TourCost;
import com.fis.lip.beans.TourPackage;
import com.fis.lip.business.TourPackageMgr;

public class Test {

	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Source location:");
			String source = sc.next();
			System.out.println("Enter the Destination location:");
			String dest = sc.next();
			System.out.println("Enter the Number of days:");
			int days = sc.nextInt();
//	String source = "MOHALI";
			//String dest = "GOA";
			//int days = 10;
			TourPackageMgr mgr = new TourPackageMgr();
			List<TourPackage> list = mgr.getAllPackages();
			System.out.println("\nList of all available packages:");
			for (TourPackage tourPackage : list) {
				System.out.println(tourPackage);
			}
			System.out.println("\n- - - - - - -");

			try {
				TourCost tourCost = mgr.getCost(source, dest, days);
				System.out.printf("\nTotal Cost for %d day trip from %s to %s is: %f\n", days, source, dest,
						tourCost.getTotalCost());
				System.out.println("\nDetails are as follows:" + tourCost);
			} catch (NoPackageFoundException e) {
				System.out.printf("\nPackage for %s to %s doesn't currently exist!", source, dest);
			}
		}
	}

}
