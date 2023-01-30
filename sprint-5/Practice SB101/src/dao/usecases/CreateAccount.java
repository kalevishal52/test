package dao.usecases;

import dao.AccountDao;
import dao.AccountDaoImplemention;
import dao.exception.InvalidAccount;
import dao.model.Account;

public class CreateAccount {

	public static void main(String[] args) {
		
		AccountDao ad = new AccountDaoImplemention();
		
		Account account = new Account(10003, "caca@gma.com", "Madha", 2000);
		
//		ad.save(account);
		
		try {
			Account ac = ad.findById(10002);
			
			System.out.println(ac);
		} catch (InvalidAccount e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
