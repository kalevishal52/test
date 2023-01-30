package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		
		System.out.println("ENter roll");
		int roll = input.nextInt();
		
		System.out.println("ENter name");
		String name = input.next();
		
		System.out.println("ENter address");
		String address = input.next();
		
		System.out.println("ENter marks");
		int marks = input.nextInt();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/vishaldb"; 
		
		try(Connection conn = DriverManager.getConnection(url, "root", "M@)Vishal!@L")) {
		
			if(conn != null) {
				System.out.println("Connected to db..");
			}
			
			Statement st = conn.createStatement();
			
			int affectedRow =  st.executeUpdate("insert into student values("+roll+", '"+name+"', '"+address+"',"+marks+" )") ;
			
			if(affectedRow > 0) {
				System.out.println("inserted");
			}
			else {
				System.out.println("Failing Insert");
			}
		} catch (SQLException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
