package com.collabera.jdbc.examples;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class RowSetExample {
	
	public static void main(String[] args) {
		
		try {
			
			// created row set
			JdbcRowSet rowSet = new JdbcRowSetImpl();
			
			// pass info for the connection
			rowSet.setUrl("jdbc:mysql://localhost:3306/university");
			rowSet.setUsername("root");
			rowSet.setPassword("root");
			
			// select your query
			rowSet.setCommand("select * from student");
			
			// execute
			rowSet.execute();
			
			
			// display results
			System.out.println("STUDENTS");
			System.out.println("--------------------------------");
			
			while(rowSet.next()) {
				System.out.println("ID: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2) +
						" " + rowSet.getString(3));
			}
			
			rowSet.close();			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
 		
	}

}
