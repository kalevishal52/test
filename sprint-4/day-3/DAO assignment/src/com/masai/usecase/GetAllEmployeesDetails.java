package com.masai.usecase;

import java.util.List;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImplClass;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class GetAllEmployeesDetails {

	public static void main(String[] args) {
		
		EmployeeDao emp = new EmployeeDaoImplClass();
		
		try {
			List<Employee> empList = emp.getAllEmployees();
			
			empList.forEach(e -> System.out.println(e));
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
