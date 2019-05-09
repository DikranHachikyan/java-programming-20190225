package app;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Main {
	
	public static void main(String[] args) {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
	 
		String sql = "SELECT * FROM contacts WHERE company_name LIKE 'C%'";
		
		try(Connection conn = DriverManager.getConnection(url + 
				                                      db +
				                                      "?user=" + user + 
				                                      "&password=" + password);
			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
												 ResultSet.CONCUR_UPDATABLE);
			ResultSet rset = stm.executeQuery(sql)){
			//------------------------------------------------------------
			System.out.println("Before insert");
			while( rset.next()) {
				System.out.println(rset.getString("id") + "|" + 
								   rset.getString("last_name") + "|" + 
								   rset.getString("company_name") + "|" +
								   rset.getString("status") + "|");
				if( rset.getString("last_name").equals("Mendoza") ){
					rset.moveToInsertRow();
					
					rset.updateString("first_name", "John");
					rset.updateString("last_name", "Doe");
					rset.updateString("company_name", "JD Ltd");
					
					rset.insertRow();
					
					rset.moveToCurrentRow();
					
				}
				
			}
			//-------------------------------------------------------------
			System.out.println("after insert");
			rset.beforeFirst();
			while( rset.next()) {
				System.out.println(rset.getString("id") + "|" + 
								   rset.getString("last_name") + "|" + 
						           rset.getString("company_name") + "|" +
								   rset.getString("status") + "|");
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