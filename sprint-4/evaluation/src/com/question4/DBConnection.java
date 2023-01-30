package com.question4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection provideConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/sprint4" ;
		
		try {
			Connection conn =  DriverManager.getConnection(url, "root", "M@)Vishal!@L") ;
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
}
