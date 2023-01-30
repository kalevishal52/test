package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImplClass;
import com.masai.exception.EmployeeException;

public class GetEmployeeSalaryById {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Employee id to search Employee");
		int eid = input.nextInt();
		
		EmployeeDao emp = new EmployeeDaoImplClass();
		
		try {
			int salary =  emp.getSalaryByEmpId(eid);
			System.out.println("Salray of eid " + eid + " is " + salary);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
