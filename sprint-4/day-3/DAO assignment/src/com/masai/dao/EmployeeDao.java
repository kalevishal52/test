package com.masai.dao;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeDao {

	public int getSalaryByEmpId(int id) throws EmployeeException ;
	
	public List<Employee> getAllEmployees() throws EmployeeException ;
	
	public String provideBonusToAllEmployee(int bonousAmount) throws EmployeeException ;
	
	public String insertEmployeeDataWithotData(Employee employee) throws EmployeeException ;

	public Employee searchEmployeeById(int eid) throws EmployeeException ;
	
}
