package com.question5.usecases;

import java.util.Scanner;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;
import com.question5.InvalidAccount;

public class RemoveAccount {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your ac number Which you want to Delete");
		int id = input.nextInt();
		
		Account account = new Account(id, null, null, 0);
		
		AccountDao ad = new AccountDaoImpl();
		
		try {
			ad.remove(account);
		} catch (InvalidAccount e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
