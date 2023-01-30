package com.question5.usecases;

import java.util.Scanner;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;
import com.question5.InvalidAccount;

public class Deposite {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your ac number to Deposite");
		int id = input.nextInt();
		
		System.out.println("Enter Deposite amount");
		double depAmt = input.nextDouble();
		
		Account account = new Account(id, null, null, 0);
		
		AccountDao ad = new AccountDaoImpl();	
		
		try {
			String res =  ad.deposit(depAmt, account);
			
			System.out.println(res);
			
		} catch (InvalidAccount e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
