package app;

import java.sql.CallableStatement;
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
	 
		String sql = "{call calc_total_orders(?,?)}";
		
		try(Connection conn = DriverManager.getConnection(url + 
				                                      db +
				                                      "?user=" + user + 
				                                      "&password=" + password);
				
			CallableStatement cstm = conn.prepareCall(sql)){		
			System.out.println("Connection successful");
			cstm.setString(1, "ALFKI");
			cstm.registerOutParameter(2, java.sql.Types.DECIMAL);
			cstm.execute();
			System.out.println("Total (ALFKI):" + cstm.getDouble(2)); //4596.2
			
			
			
		}
		catch( SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
		}
		
	}	
}