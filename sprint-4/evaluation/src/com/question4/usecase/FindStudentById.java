package com.question4.usecase;

import java.util.Scanner;

import com.question4.dao.ABCDao;
import com.question4.dao.ABCDaoImplCalss;
import com.question4.dao.Student;
import com.question4.dao.StudentException;

public class FindStudentById {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter s roll");
		int roll = input.nextInt();
		
		ABCDao abc = new ABCDaoImplCalss();
		
		try {
			Student student = abc.findStudentById(roll);
			
			System.out.println(student);
			
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
