package com.question5;

public interface AccountDao {

	void save(Account account);
	
	Account findById(int id) throws InvalidAccount;
	
	void updateEmail(Account account) throws InvalidAccount;
	
	void remove(Account account) throws InvalidAccount;
	
	int withdraw(double amount, Account account) throws InsufficientBalance;
	
	String deposit(double amount, Account account) throws InvalidAccount;

	
}
