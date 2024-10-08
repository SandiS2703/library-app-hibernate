package com.itenas.uas.rpl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/uas_rpl?useSSL=false";
		String username = "root";
		String password = "";
		
		try {
			System.out.println("Connecting to mysql: " + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			
			System.out.println("Connection successfull: " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
