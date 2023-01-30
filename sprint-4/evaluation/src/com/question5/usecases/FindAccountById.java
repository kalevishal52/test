package com.question5.usecases;

import java.util.Scanner;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;
import com.question5.InvalidAccount;

public class FindAccountById {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your ac/no to get deatils");
		int id = input.nextInt();
		
		AccountDao ad = new AccountDaoImpl();
		
		try {
			Account account = ad.findById(id);
			
			System.out.println(account);
			
		} catch (InvalidAccount e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
