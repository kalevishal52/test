package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db2";  
		
		try (Connection conn = DriverManager.getConnection(url, "root", "M@)Vishal!@L")) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee2 values(?,?,?,?);") ;
			
			while(true) {
				System.out.println("Enter Employee ID");
				int eid = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter Employee Name (15characters)");
				String name = input.next();
				
				System.out.println("Enter Employee Address (15characters)");
				String address = input.next();
				
				System.out.println("Enter Employee Salary");
				int salary = input.nextInt();
				
				ps.setInt(1, eid);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setInt(4, salary);
				
				int rowAffected = ps.executeUpdate();
				
				if(rowAffected > 0) {
					System.out.println("Record Inserted....");
				} else {
					System.out.println("Record Insert Fail.....");
				}
				
				System.out.println("Want to insert more records");
				String res = input.next();
				if(res.equalsIgnoreCase("n")) {
					break;
				}
				System.out.println("_______________________________");
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}
	
}
