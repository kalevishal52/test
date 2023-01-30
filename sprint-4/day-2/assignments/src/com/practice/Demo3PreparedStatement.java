package com.practice;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3PreparedStatement {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/vishaldb";

		
		
		try (Connection conn = DriverManager.getConnection(url, "root", "M@)Vishal!@L"))  {
			
			if (conn != null) {
				System.out.println("Connected to db..");
			}

//			Statement st = conn.createStatement();
//			int affectedRow =  st.executeUpdate("insert into student values("+roll+", '"+name+"', '"+address+"',"+marks+" )") ;

			
//			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?);") ;
//			ps.setInt(1, 52);
//			ps.setString(2, "Vishal");
//			ps.setString(3, "Kwd");
//			ps.setInt(4, 30);
//
//			int rowAffected =  ps.executeUpdate();
//			if(rowAffected > 0) {
//				System.out.println("Insert sucessful");
//			} else {
//				System.out.println("Not inserted");
//			}
			
			PreparedStatement ps =  conn.prepareStatement("select * from student ;") ;

			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				String add = rs.getString("address");
				int marks = rs.getInt("marks");
				
				System.out.println(roll);
				System.out.println(name);
				System.out.println(add);
				System.out.println(marks);
			}
			
			
//			
//			PreparedStatement ps = conn.prepareStatement("delete from student where roll = ? ;") ;
//			
//			System.out.println("Enter the roll to delete the student");
//			int roll= input.nextInt();
//			
//			ps.setInt(1, roll);
//			
//			int affectedRow = ps.executeUpdate();
//			
//			if (affectedRow > 0) {
//				System.out.println("Deleted roll " + roll);
//			} else {
//				System.out.println("Failing Delete");
//			}
//							<---------	Insertin a record   -------->
			
//			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?);");
			/*
			while (true) {
				System.out.println("ENter roll");
				int roll = input.nextInt();

				System.out.println("ENter name");
				String name = input.next();

				System.out.println("ENter address");
				String address = input.next();

				System.out.println("ENter marks");
				int marks = input.nextInt();

				ps.setInt(1, roll);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setInt(4, marks);

				int affectedRow = ps.executeUpdate();

				if (affectedRow > 0) {
					System.out.println("inserted");
				} else {
					System.out.println("Failing Insert");
				}

				System.out.println("Add more y/n");
				String res = input.next();
				if (res.equalsIgnoreCase("n")) {
					break;
				}
				System.out.println("____________________________________");
			}
		*/
			
			
			
		} catch (SQLException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
