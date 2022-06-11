package com.kos.showticat.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	public static Connection getConnection() {
		
//		String url = "jdbc:oracle:thin:@testdb_medium?TNS_ADMIN=C:/Users/KOSTA/Downloads/Wallet_testDB";
//		String url2 = "jdbc:oracle:thin:@testdb_medium?TNS_ADMIN=C:/Users/lenovo/Desktop/language/SQL/KOSTA/Wallet_testDB";
//		String url3 = "jdbc:oracle:thin:@testdb_medium?TNS_ADMIN=C:/Wallet_testDB";
		String url4 = "jdbc:oracle:thin:@testdb_medium?TNS_ADMIN=C:/wallet_db/Wallet_testDB";
		String user="admin";
		String password ="Kostatestdb241";
		String driverPath ="oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		try {
			
			Class.forName(driverPath);
			conn = DriverManager.getConnection(url4, user, password);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void dbClose(Connection conn ) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
