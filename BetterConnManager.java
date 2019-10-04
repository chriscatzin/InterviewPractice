package com.collabera.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BetterConnManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/university";
	// ?serverTimezone=EST5EDT
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	
	private static void makeConnection() {
		
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch(SQLException e) {
			System.out.println("Could not connect to database");
		}
		
	}
	
	public static Connection getConnection() {
		
		if(connection == null) {
			makeConnection();
		}
		
		return connection;		
	}
	
	public static void main(String[] args) {
		
		Connection conn = BetterConnManager.getConnection();
		
		try {
			conn.close();
			System.out.println("Closed connection");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
