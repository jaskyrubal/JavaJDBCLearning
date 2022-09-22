package com.fis.lip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fis.lip.beans.TourPackage;

public class TourPackageDAO {
	public boolean create(Connection conn, TourPackage tp) throws SQLException {
		boolean isAdded = false;
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(INSERT_QUERY);
			psmt.setString(1, tp.getPackageId());
			psmt.setString(2, tp.getSource());
			psmt.setString(3, tp.getDest());
			psmt.setDouble(4, tp.getBaseFare());
			isAdded = psmt.execute();
		} finally {
			
			if (psmt != null) {
				psmt.close();
			}
		}
		return isAdded;
	}

	public TourPackage select(Connection conn, String source, String dest) throws SQLException {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		TourPackage tp = null;
		try {
			psmt = conn.prepareStatement(SELECT_QUERY);
			psmt.setString(1, source);
			psmt.setString(2, dest);
			rs = psmt.executeQuery();
			if (rs != null && rs.next()) {
				tp = read(rs);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
		}
		return tp;
	}

	public List<TourPackage> selectAll(Connection conn) throws SQLException {
		List<TourPackage> list = new ArrayList<>();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		TourPackage tp = null;
		try {
			psmt = conn.prepareStatement(SELECT_BASE_QUERY);
			rs = psmt.executeQuery();
			while (rs != null && rs.next()) {
				tp = read(rs);
				list.add(tp);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
		}
		return list;
	}
	private TourPackage read(ResultSet rs) throws SQLException {
		TourPackage tourPackage = new TourPackage();
		tourPackage.setPackageId(rs.getString("PACKAGE_ID"));
		tourPackage.setSource(rs.getString("SOURCE"));
		tourPackage.setDest(rs.getString(3));
		tourPackage.setBaseFare(rs.getDouble(4));

		return tourPackage;
	}
	private static final String SELECT_BASE_QUERY="SELECT PACKAGE_ID, SOURCE, DEST, BASE_FARE FROM PACKAGE_INFO";
	private static final String SELECT_QUERY= SELECT_BASE_QUERY+" WHERE SOURCE = ? AND DEST = ?";
	private static final String INSERT_QUERY="INSERT INTO PACKAGE_INFO(PACKAGE_ID, SOURCE, DEST, BASE_FARE) VALUES(?, ?, ?, ?)";

}
