package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImplClass;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class GetEmployeeDeatilsById {

	public static void main(String[] args) {
		
Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Employee id to search Employee");
		int eid = input.nextInt();
		
		EmployeeDao emp = new EmployeeDaoImplClass();
		
		try {
			 Employee employee =  emp.searchEmployeeById(eid);
			  
			 System.out.println(employee);
			 
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
