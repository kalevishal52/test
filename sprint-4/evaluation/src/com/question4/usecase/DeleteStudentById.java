package com.question4.usecase;

import java.util.Scanner;

import com.question4.dao.ABCDao;
import com.question4.dao.ABCDaoImplCalss;
import com.question4.dao.StudentException;

public class DeleteStudentById {

	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter student roll which is to be deleted");
		int roll = input.nextInt();
		
		ABCDao abc = new ABCDaoImplCalss();
		
		try {
			String res = abc.deleteStudentById(roll);
			
			System.out.println(res);
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
