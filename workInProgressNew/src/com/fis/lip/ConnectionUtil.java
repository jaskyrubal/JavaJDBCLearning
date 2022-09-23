package com.fis.lip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		// db parameters
		String url = "jdbc:mysql://localhost:3306/packages";
		String user = "root";
		String password = "root";

		// create a connection to the database
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
