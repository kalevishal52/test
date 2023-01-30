package com.question5.usecases;

import java.util.Scanner;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;
import com.question5.InvalidAccount;

public class UpdateEmail {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your ac number");
		int id = input.nextInt();
		
		System.out.println("Enter your new email Address");
		String email = input.next();
		
		Account account = new Account(id, email, null, 0);
		
		AccountDao ad = new AccountDaoImpl();
		
		try {
			ad.updateEmail(account);
		} catch (InvalidAccount e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
