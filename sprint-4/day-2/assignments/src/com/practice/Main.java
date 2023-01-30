package com.practice;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/vishaldb"; 
		
		try(Connection conn =  DriverManager.getConnection(url, "root", "M@)Vishal!@L")) {
			
			
			if (conn != null) {
				System.out.println("Connected......");
			}
			
			Statement st =  conn.createStatement();
			
			//SQLSyntaxErrorException: Unknown column 'Vishal' in 'field list'
//	false	int rowAffected = st.executeUpdate("insert into student values(10, Vishal, Kurduwadi, 100);") ;
			
			int rowAffected = st.executeUpdate("insert into student values(11, 'Ajinkya', 'Pune', 480);") ;
			
			if(rowAffected > 0) {
				System.out.println("Inseted Sucessfully");
			}
			else {
				System.out.println("Insettion FAIL");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
