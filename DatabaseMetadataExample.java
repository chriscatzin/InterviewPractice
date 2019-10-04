package com.collabera.jdbc.examples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataExample {
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila",
															"root", "root");
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			
			// DATABASE INFO
			ResultSet rs = dbmd.getTables("university", "public", "%", new String[] { "TABLE" });
			
			rs.first();
			
			System.out.println("\nTables");
			System.out.println("---------------------------------");
			do {
				System.out.println(rs.getString("TABLE_NAME"));
				
			} while(rs.next());
			
			System.out.println("\n\n\n");
			
			// CONNECTION INFO
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Username: " + dbmd.getUserName());
			
			
			rs = dbmd.getCatalogs();
			rs.first();
			
			System.out.println("\n\nDATABASES");
			System.out.println("--------------------------------");
			do {
				System.out.println(rs.getString(1));
				
			} while(rs.next());
			
			
			rs.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
