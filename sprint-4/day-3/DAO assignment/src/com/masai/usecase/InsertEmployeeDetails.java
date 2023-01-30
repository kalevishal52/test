package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImplClass;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class InsertEmployeeDetails {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("ENter Emp ID");
		int eid = input.nextInt();
		
		System.out.println("ENter Emp Name");
		String name = input.next();
		
		System.out.println("ENter address of Student");
		String address = input.next();
		
		System.out.println("ENter Emp salary");
		int salary = input.nextInt();
		
		EmployeeDao emp = new EmployeeDaoImplClass();
		
		Employee employee = new Employee(eid, name, address, salary);
		
		try {
			String result =  emp.insertEmployeeDataWithotData(employee);
			
			System.out.println(result);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
