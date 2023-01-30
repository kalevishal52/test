package com.question4.usecase;

import java.util.Scanner;

import com.question4.dao.ABCDao;
import com.question4.dao.ABCDaoImplCalss;
import com.question4.dao.StudentException;

public class UpdateStudentNameById {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter student rollno of which name will be updated");
		int roll = input.nextInt();
		
		System.out.println("Enter student New Name to be updated");
		String name = input.next();
		
		ABCDao abc = new ABCDaoImplCalss();
		
		try {
			String res =  abc.updateStudentNameById(roll, name);
			
			System.out.println(res);
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
