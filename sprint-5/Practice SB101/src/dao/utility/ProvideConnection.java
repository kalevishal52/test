package dao.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProvideConnection {

	public static Connection provideConnection() {
//		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/bankDB" ;;
//		String url = "jdbc:mysql://localhost/3306/bankdb" ;
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "M@)Vishal!@L");
			return conn;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
}
