package com.question4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.question4.DBConnection;

public class ABCDaoImplCalss implements ABCDao {

	@Override
	public String insertStudentDetails(Student student) throws StudentException {
		String result = "Student not Inserted" ;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into abcdatabases values (?,?,?,?,?);") ;
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getStandard());
			ps.setString(4, student.getDate());
			ps.setInt(5, student.getFees());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				result = "Student inserted sucessfully" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage();
		}
		
		
		return result;
	}

	@Override
	public Student findStudentById(int id) throws StudentException {
		Student student = null;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from abcdatabases where Rollno = ?") ;
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				int roll = rs.getInt("rollno") ;
				String name = rs.getString("StudentName");
				String standard = rs.getString("standard");
				String date = rs.getString("Date_of_Birth");
				int fees = rs.getInt("fees") ;
				
				student = new Student(roll, name, standard, date, fees);
				
			} else {
				throw new StudentException("Student not found with roll " + id);
			}
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return student;
	}

	@Override
	public Student findStudentByNameAndID(int id, String name) throws StudentException {
Student student = null;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from abcdatabases where Rollno = ? AND StudentName = ? ") ;
			ps.setInt(1, id);
			ps.setString(2, name);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				int roll = rs.getInt("rollno") ;
				String sname = rs.getString("StudentName");
				String standard = rs.getString("standard");
				String date = rs.getString("Date_of_Birth");
				int fees = rs.getInt("fees") ;
				
				student = new Student(roll, sname, standard, date, fees);
				
			} else {
				throw new StudentException("Student not found with roll " + id + " and name " + name);
			}
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return student;
	}

	@Override
	public String updateStudentNameById(int id,String newName) throws StudentException {
		String result = "Student name not updated" ;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("update abcdatabases set studentname = ? where rollno = ?;") ;
			ps.setString(1, newName);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				result = "Student name Updated sucessfully" ;
			}
			
			
			
		} catch (SQLException e) {
			result = e.getMessage();
		}
		
		return result;
	}

	@Override
	public String deleteStudentById(int id) throws StudentException {
		String result = "Student not deleted" ;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("delete from abcdatabases where rollno = ?;");
			ps.setInt(1, id);
					
			int x = ps.executeUpdate();
			if(x > 0) {
				result = "Student Deleted sucessfully with id " + id ;
			}
			
			
			
		} catch (SQLException e) {
			result = e.getMessage();
		}
		
		return result;
	}

}
