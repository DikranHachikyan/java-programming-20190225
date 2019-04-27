package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
		String sql = "SELECT " +
					 " customerid cid\n" + 
					 ", companyname company\n" + 
				     ", country\n" + 
				     "FROM customers\n" + 
				     "LIMIT 0,10";
		try(Connection conn = DriverManager.getConnection(url + 
				                                      db +
				                                      "?user=" + user + 
				                                      "&password=" + password);
				
			Statement stm = conn.createStatement();
			ResultSet rset = stm.executeQuery(sql)){
			
			System.out.println("Connection successful");
			
			rset.afterLast();
			while( rset.previous()) {
				System.out.println(rset.getRow() + " " +
								   rset.getString(1) + "|" +
								   rset.getString("company") + "|" +
								   rset.getString("country"));
				System.out.println("-----------------------------------");
			}
			
			
		}
		catch( SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
		}
		
	}	
}