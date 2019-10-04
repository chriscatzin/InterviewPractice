package com.collabera.jdbc.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManagerWithProperties {
	
	private static Connection connection = null;
	
	private static void makeConnection() {
		
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream("resources/config.properties"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
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
