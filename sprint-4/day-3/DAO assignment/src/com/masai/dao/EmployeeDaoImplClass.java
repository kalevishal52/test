package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.utility.DBConnection;
import com.mysql.cj.PerConnectionLRUFactory;

public class EmployeeDaoImplClass implements EmployeeDao{

	@Override
	public int getSalaryByEmpId(int id) throws EmployeeException {
		int salary = 0;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select salary from employee2 where eid = ?") ;
			
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				int s = rs.getInt("salary");
				salary = s;
			}
			else {
				throw new EmployeeException("Emp id not correct " + id);
			}
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		return salary;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		List<Employee> employeesList = new ArrayList();
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee2;") ;
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid") ;
				String name = rs.getString("name") ;
				String address = rs.getString("address") ;
				int salary = rs.getInt("salary") ;
				
				Employee e = new Employee(eid, name, address, salary);
				employeesList.add(e);
			}
			if(employeesList.size() == 0) {
				throw new EmployeeException("No employees in table");
			}
		
		
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		return employeesList;
	}

	@Override
	public String provideBonusToAllEmployee(int bonousAmount) throws EmployeeException{
		String result = "Bonus not added";
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee2 set salary = salary + ? ;") ;
			
			ps.setInt(1, bonousAmount);
			
			int x =  ps.executeUpdate();
			
			if(x > 0) {
				result = "Bonus added sucessfully" ;
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return result ;
	}

	@Override
	public String insertEmployeeDataWithotData(Employee employee) throws EmployeeException {
		String result = "Emp data not inserted " ;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into employee2 values(?,?,?,?);") ;
			
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int x =  ps.executeUpdate();
			if(x > 0) {
				result = "Employee added sucessfully" ;
			}
			
		} catch (SQLException e) {
			result = e.getMessage();
		}
		
		return result;
	}

	@Override
	public Employee searchEmployeeById(int eid) throws EmployeeException {
		Employee employee = null;
		
		try (Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from employee2 where eid = ? ;"); ;
			
			ps.setInt(1, eid);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("eid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int salary = rs.getInt("salary");
				
				employee = new Employee(empId, name, address, salary);
			}
			else {
				throw new EmployeeException("Emp not found of id " + eid);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	
	
}
