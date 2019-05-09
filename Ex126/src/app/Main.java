package app;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Main {
	
	public static void main(String[] args) {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
	 
		String sql = "INSERT INTO contacts\n" + 
					 "(id,first_name, last_name, phone, company_name, country, status)\n" + 
					 "VALUES\n" + 
					 "(null, 'Maria', 'Anders', '333-22-11', 'MA Ltd', 'Germany', 'P')";
		
		try(Connection conn = DriverManager.getConnection(url + db, user, password)){
			//Connection settings
			conn.setAutoCommit(false);
			System.out.println("Isolation Level:" + conn.getTransactionIsolation());
			
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			//
			try(Statement stm = conn.createStatement()){
				int afcRows = stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				Scanner scan = new Scanner(System.in);
				System.out.println("Choose (c)ommit or (r)ollback:");
				char ans = scan.next().charAt(0);
				
				if( ans == 'c' ) {
					conn.commit();
					System.out.println("Affected Rows:" + afcRows + " ins:" + stm.getUpdateCount());
					//Read Keys
					try( ResultSet rset = stm.getGeneratedKeys()){
						while( rset.next()) {
							System.out.println("new contact id:" + rset.getInt(1));
						}
					}// read keys
				}//commit
				else if( ans == 'r') {
					conn.rollback();
					System.out.println("Rollback !!");
				}
			}// try Statement stm ...
		}
		catch(SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
		}
		
	}	
}