package dao;

import dao.exception.InsufficientBalance;
import dao.exception.InvalidAccount;
import dao.model.Account;

public interface AccountDao {

	void save(Account account);
	
	Account findById(int id) throws InvalidAccount;
	
	void update(Account account) throws InvalidAccount;
	
	void remove(Account account) throws InvalidAccount;
	
	int withdraw(double amount, Account account) throws InsufficientBalance;
	
	String deposit(double amount, Account account) throws InvalidAccount;
	
}
