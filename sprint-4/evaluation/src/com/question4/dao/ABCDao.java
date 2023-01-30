package com.question4.dao;

public interface ABCDao {

	public String insertStudentDetails(Student student) throws StudentException;
	
	public Student findStudentById(int id) throws StudentException;
	
	public Student findStudentByNameAndID(int id,String name) throws StudentException;
	
	public String updateStudentNameById(int id,String newName) throws StudentException; 
	
	public String deleteStudentById(int id) throws StudentException; 
	
}
