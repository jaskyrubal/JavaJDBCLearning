package com.fis.lip.business;

import com.fis.lip.InvalidPackageException;
import com.fis.lip.beans.TourPackage;

public class TourPackageValidator {

	public boolean isNullOrBlank(String s) {
		if (s == null) {
			return true;
		}
		if (s.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public void validate(TourPackage tp) throws InvalidPackageException {
		String s = tp.getPackageId();
		// Put Conditions here
		if (isNullOrBlank(s)) {
			throw new InvalidPackageException("Package ID is empty!");
		}
		if (s.length() != 7) {
			throw new InvalidPackageException("Invalid Package ID! Package ID must be of 7 characters..");
		}
		s=tp.getSource();
		if (isNullOrBlank(s)) {
			throw new InvalidPackageException("Source is empty!");
		}
		s=tp.getDest();
		if (isNullOrBlank(s)) {
			throw new InvalidPackageException("Destination is empty!");
		}
		double i = tp.getBaseFare();
		if (i==0) {
			throw new InvalidPackageException("Base Fare can not be Zero!");
		}
		
		
	}
}
