package app;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
	 
		try(Connection conn = DriverManager.getConnection(url + db, user, password)) {
			DatabaseMetaData dbmt = conn.getMetaData();
			
			System.out.println("list of tables:");
			
			ResultSet res = dbmt.getTables("northwind", null, null, null);
			while( res.next()) {
				System.out.println(res.getString("TABLE_TYPE") + "=>" + 
								   res.getString("TABLE_NAME"));
			}
			
			
		}
		catch(SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
			
		}
		
	}	
}