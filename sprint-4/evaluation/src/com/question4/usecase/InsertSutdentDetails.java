package com.question4.usecase;

import java.util.Scanner;

import com.question4.dao.ABCDao;
import com.question4.dao.ABCDaoImplCalss;
import com.question4.dao.Student;
import com.question4.dao.StudentException;

public class InsertSutdentDetails {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter s roll");
		int roll = input.nextInt();
		
		System.out.println("Enter s name");
		String name = input.next();
		
		System.out.println("Enter s Standard in roman numbers");
		String standard = input.next();

		System.out.println("Enter s date in yyyy-mm-dd format");
		String date = input.next();
		
		System.out.println("Enter s fees");
		int fees = input.nextInt();
		
		ABCDao abc = new ABCDaoImplCalss();
		
		Student student = new Student(roll, name, standard, date, fees);
		
		 try {
			String res =  abc.insertStudentDetails(student) ;
			
			System.out.println(res);
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
