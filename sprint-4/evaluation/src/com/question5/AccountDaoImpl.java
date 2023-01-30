package com.question5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void save(Account account) {
		
		try (Connection conn = DBAccountConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into account values(?,?,?,?);") ;
			
			ps.setInt(1, account.getId());
			ps.setString(2, account.getEmail());
			ps.setString(3, account.getAddress());
			ps.setDouble(4, account.getBalance());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println("Account Saved sucessfully");
			}
					
					
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Account findById(int id) throws InvalidAccount {
		Account account = null;
		
		try (Connection conn = DBAccountConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from account where id = ?;") ;
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();		
			
			if(rs.next()) {
				int acid = rs.getInt("id");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int balance = rs.getInt("balance");
				
				account = new Account(acid, email, address, balance);
			}
			else {
				throw new InvalidAccount("Account not found with ac/no " + id);
			}
					
		} catch (SQLException e) {
			throw new InvalidAccount(e.getMessage());
		}
		
		
		return account;
	}

	@Override
	public void updateEmail(Account account) throws InvalidAccount {
		
		try (Connection conn = DBAccountConnection.provideConnection()) {

			PreparedStatement ps =  conn.prepareStatement("update account set email = ? where id = ? ;") ;
			
			ps.setString(1, account.getEmail());
			ps.setInt(2, account.getId());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println("Account Email Updated sucessfully");
			} 
			else {
				throw new InvalidAccount("account not found with id " + account.getId());
			}
					
					
		} catch (SQLException e) {
			throw new InvalidAccount(e.getMessage());
		}
		
	}

	@Override
	public void remove(Account account) throws InvalidAccount {
		
		try (Connection conn = DBAccountConnection.provideConnection()) {

			PreparedStatement ps =  conn.prepareStatement("delete from account where id = ?") ;
			
			ps.setInt(1, account.getId());
		
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println("Account Deleted Sucessfully");
			} 
			else {
				throw new InvalidAccount("account not found with id " + account.getId());
			}
					
					
		} catch (SQLException e) {
			throw new InvalidAccount(e.getMessage());
		}
		
	}

	@Override
	public int withdraw(double amount, Account account) throws InsufficientBalance {
		int widralAmount = 0 ;
		

		try (Connection conn = DBAccountConnection.provideConnection()) {

			PreparedStatement ps =  conn.prepareStatement("select balance from account where id = ? ;");
			ps.setInt(1, account.getId());
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				double balance = rs.getDouble("balance") ;
				
				if(balance >= amount) {
					
					PreparedStatement ps2 =  conn.prepareStatement("update account set balance = balance - ? where id = ?");
					ps2.setDouble(1, amount);
					ps2.setInt(2, account.getId());
					
					int res =  ps2.executeUpdate();
					
					if(res > 0) {
						widralAmount = (int) amount;
						
					}
				}
				else {
					throw new InsufficientBalance("Balance is not sufficient to widrawal");
				}
				
			} else {
				throw new InsufficientBalance("No account found");
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsufficientBalance(e.getMessage());
		}
		
		
		return widralAmount;
	}

	@Override
	public String deposit(double amount, Account account) throws InvalidAccount {
		String result = "Deposite failed";
		
		try (Connection conn = DBAccountConnection.provideConnection()) {

			PreparedStatement ps =  conn.prepareStatement("update account set balance = balance + ? where id = ? ;") ;
			
			ps.setDouble(1, amount);
			ps.setInt(2, account.getId());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Balance added sucessfully" ;
			} 
			else {
				throw new InvalidAccount("Account not found with a/c " + account.getId() );
			}
					
					
		} catch (SQLException e) {
			throw new InvalidAccount(e.getMessage());
		}
		
		
		return result;
	}

}
