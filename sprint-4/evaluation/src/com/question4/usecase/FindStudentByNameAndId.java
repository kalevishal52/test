package com.question4.usecase;

import java.util.Scanner;

import com.question4.dao.ABCDao;
import com.question4.dao.ABCDaoImplCalss;
import com.question4.dao.Student;
import com.question4.dao.StudentException;

public class FindStudentByNameAndId {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter student roll");
		int roll = input.nextInt();
		
		System.out.println("Enter student name");
		String name = input.next();
		
		ABCDao abc = new ABCDaoImplCalss();
		
		try {
			Student student = abc.findStudentByNameAndID(roll, name);
			
			System.out.println(student);
			
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
