package com.question5.usecases;

import java.util.Scanner;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;
import com.question5.InsufficientBalance;

public class Withdrawal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your ac number to widrawal");
		int id = input.nextInt();
		
		System.out.println("Enter widrewal amount");
		double widAmt = input.nextDouble();
		
		Account account = new Account(id, null, null, 0);
		
		AccountDao ad = new AccountDaoImpl();
		
		try {
			int amt =  ad.withdraw(widAmt, account);
			
			System.out.println(amt + " withdraw sucessfull");
			
		} catch (InsufficientBalance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
