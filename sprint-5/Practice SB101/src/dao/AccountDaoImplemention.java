package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.exception.InsufficientBalance;
import dao.exception.InvalidAccount;
import dao.model.Account;
import dao.utility.ProvideConnection;

public class AccountDaoImplemention implements AccountDao {

	@Override
	public void save(Account account) {
		
		
		
		try (Connection conn =  ProvideConnection.provideConnection();) {
			PreparedStatement ps =  conn.prepareStatement("insert into account values(?,?,?,?) ;") ;
			
			ps.setInt(1, account.getId());
			ps.setString(2, account.getEmail());
			ps.setString(3, account.getAddress());
			ps.setDouble(4, account.getBalance());
			
			int affectedRow = ps.executeUpdate();
			
			if(affectedRow > 0) {
				System.out.println("Account sucessfull added");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account findById(int id) throws InvalidAccount {
		Account account = null;
		
		try (Connection conn =  ProvideConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from account where id = ? ;");
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				int eid = rs.getInt("id");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int balance = rs.getInt("balance");
				
				account = new Account(eid, email, address, balance);
				
			} else {
				throw new InvalidAccount("Account not found");
			}
			
		} catch (SQLException e) {
			throw new InvalidAccount(e.getMessage());
		}
		
		return account;
	}

	@Override
	public void update(Account account) throws InvalidAccount {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Account account) throws InvalidAccount {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int withdraw(double amount, Account account) throws InsufficientBalance {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deposit(double amount, Account account) throws InvalidAccount {
		// TODO Auto-generated method stub
		return null;
	}

}
