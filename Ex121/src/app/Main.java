package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Main {
	
	public static void main(String[] args) {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
		// String sql = "SELECT * FROM " + tables 
		String sql = "SELECT " +
					 " customerid cid\n" + 
					 ", companyname company\n" + 
				     ", country\n" + 
				     "FROM customers\n" +
				     "WHERE country = ? \n" +
				     "LIMIT 0,10";
		//String [] countries = {"Germany", "AUK", "USA", "France"};
		String [] countries = {"Germany", "UK", "USA", "France"};
		
		try(Connection conn = DriverManager.getConnection(url + 
				                                      db +
				                                      "?user=" + user + 
				                                      "&password=" + password);
				
			PreparedStatement pstm = conn.prepareStatement(sql)){		
			System.out.println("Connection successful");
			
			for( final String country : countries) {
				System.out.println("----------- Country:" + country + " ------------");
				pstm.setString(1,country);
				try(ResultSet rset = pstm.executeQuery()){
					while(rset.next()) {
						System.out.println(rset.getRow() + "|" +
										   rset.getString(1) + "|" +
										   rset.getString(2) + "|" + 
										   rset.getString(3) );
					}
				}
			}//for each country
			
		}
		catch( SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
		}
		
	}	
}