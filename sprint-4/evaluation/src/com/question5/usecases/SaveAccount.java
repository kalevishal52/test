package com.question5.usecases;

import com.question5.Account;
import com.question5.AccountDao;
import com.question5.AccountDaoImpl;

public class SaveAccount {

	public static void main(String[] args) {
		
		AccountDao ad = new AccountDaoImpl();
		
		Account acc = new Account(10003, "cd@gmail.com", "Pune", 2000) ; 
		
		ad.save(acc);
		
	}
	
}
