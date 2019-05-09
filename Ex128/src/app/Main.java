package app;

import java.sql.Connection;
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
	 
		String sql = "SELECT * FROM contacts LIMIT 0,10";
		
	
		try(Connection conn = DriverManager.getConnection(url + db, user, password);
			Statement stm = conn.createStatement();
			ResultSet rset = stm.executeQuery(sql);) {
			
			ResultSetMetaData resMeta =  rset.getMetaData();
			
			int colCount = resMeta.getColumnCount();
			System.out.println("Column Count:" + colCount);
			
			for( int i = 1; i <= colCount; i++) {
				System.out.println("Name:" + resMeta.getColumnName(i) +
								   " Type:" + resMeta.getColumnType(i) +
								   " Is Not Required:" + resMeta.isNullable(i) +
								   " Is Autoincreemnt:" + resMeta.isAutoIncrement(i));  
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