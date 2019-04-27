package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
		try(Connection conn = DriverManager.getConnection(url + 
				                                      db +
				                                      "?user=" + user + 
				                                      "&password=" + password)){
			System.out.println("Connection successful");
			
		}
		catch( SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
		}
		
	}	
}