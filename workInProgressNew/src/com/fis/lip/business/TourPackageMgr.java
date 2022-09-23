package com.fis.lip.business;

import java.sql.Connection;
import java.util.List;

import com.fis.lip.ConnectionUtil;
import com.fis.lip.NoPackageFoundException;
import com.fis.lip.beans.TourCost;
import com.fis.lip.beans.TourPackage;
import com.fis.lip.dao.TourPackageDAO;

public class TourPackageMgr {
	private TourPackageValidator validator;

	public TourPackageMgr() {
		validator = new TourPackageValidator();
	}

	private double getDiscountRate(int days) {
		double discount = 0.0;
		if (days > 5 && days <= 8) {
			discount = 3.0;
		} else if (days > 8 && days <= 10) {
			discount = 5.0;
		} else if (days > 10) {
			discount = 7.0;
		}
		return discount;
	}

	private TourCost getCost(Double fare, int days) {
		TourCost tourCost = new TourCost();
		double basicCost = fare * days;
		double discountRate = getDiscountRate(days);
		double discount = (basicCost * discountRate) / 100.0;
		double discountedCost = basicCost - discount;
		double gst = 0.12 * discountedCost;
		double totalCost = discountedCost + gst;
		tourCost.setDays(days);
		tourCost.setBaseFare(fare);
		tourCost.setTotalBaseCost(basicCost);
		tourCost.setDiscountRate(discountRate);
		tourCost.setDiscount(discount);
		tourCost.setDiscountedCost(discountedCost);
		tourCost.setGst(gst);
		tourCost.setTotalCost(totalCost);
		return tourCost;
	}

	public TourCost getCost(String source, String dest, int days) throws Exception {

		TourCost tourCost = null;
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			TourPackageDAO dao = new TourPackageDAO();
			TourPackage tp = dao.select(conn, source, dest);
			if (tp != null) {
				tourCost = getCost(tp.getBaseFare(), days);
			} else {
				throw new NoPackageFoundException();
			}

		} finally {
			ConnectionUtil.close(conn);
		}

		return tourCost;
	}

	public List<TourPackage> getAllPackages() throws Exception {
		Connection conn = null;
		List<TourPackage> list = null;
		try {
			conn = ConnectionUtil.getConnection();
			TourPackageDAO dao = new TourPackageDAO();
			list = dao.selectAll(conn);

		} finally {
			ConnectionUtil.close(conn);
		}

		return list;
	}

	public boolean addPackage(TourPackage tp) throws Exception {
		boolean isAdded = false;
		Connection conn = null;
		try {
			validator.validate(tp);
			conn = ConnectionUtil.getConnection();
			TourPackageDAO dao = new TourPackageDAO();
			isAdded = dao.create(conn, tp);

		} finally {
			ConnectionUtil.close(conn);
		}

		return isAdded;
	}

	public static void main(String[] args) throws Exception {
		TourPackageMgr mgr = new TourPackageMgr();
		System.out.println(mgr.getCost(3000.0, 15));
	}
}
