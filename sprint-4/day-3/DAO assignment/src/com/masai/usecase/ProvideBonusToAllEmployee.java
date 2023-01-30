package com.masai.usecase;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImplClass;
import com.masai.exception.EmployeeException;

public class ProvideBonusToAllEmployee {

	public static void main(String[] args) {
		
		EmployeeDao emp = new EmployeeDaoImplClass();
		
		try {
			String result =  emp.provideBonusToAllEmployee(500);
			
			System.out.println(result);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
