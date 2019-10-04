package com.collabera.jdbc.examples;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.collabera.jdbc.connection.ConnManagerWithProperties;

public class ResultSetMetadataExample {

	public static void main(String[] args) {
		
		try {
			
			Connection conn = ConnManagerWithProperties.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			
			ResultSetMetaData rsMetadata = rs.getMetaData();
			
			for(int col = 1; col <= rsMetadata.getColumnCount(); col++) {
				
				String name = rsMetadata.getColumnName(col);
				int type = rsMetadata.getColumnType(col);
				String typeName = rsMetadata.getColumnTypeName(col);
				
				System.out.println(col + ": Name = " + name + ", Type Number = " + type 
						+ ", Type Name = " + typeName);
				
			}
			
			rs.close();
			stmt.close();
			conn.close();			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
