package app;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
	 
		String insSql = "INSERT INTO contacts\n" + 
					 "(id,first_name, last_name, phone, company_name, country, status)\n" + 
					 "VALUES\n" + 
					 "(null, 'Maria', 'Anders', '333-22-11', 'MA Ltd', 'Germany', 'P')";
		
		String sql = "SELECT * FROM contacts WHERE company_name LIKE 'MA Ltd%'";
		
		String updSql = "UPDATE  contacts\n" + 
						 "SET first_name = 'Mich', \n" + 
				         "    last_name = 'Alis', \n" + 
				         "    phone = '777-66-55'\n" + 
				         "WHERE company_name LIKE 'MA Ltd%'";
		Connection conn = null;
		try { 
			conn = DriverManager.getConnection(url + db, user, password);
			//Connection settings
			conn.setAutoCommit(false);
			System.out.println("Isolation Level:" + conn.getTransactionIsolation());
			
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			try( Statement stm = conn.createStatement()){
				try( ResultSet rset = stm.executeQuery(sql)){
					if( rset.next()) {
						int updRows = stm.executeUpdate(updSql);
						System.out.println("Updated:" + updRows+ " rows");
					}
					else {
						stm.executeUpdate(insSql, Statement.RETURN_GENERATED_KEYS);
						System.out.println("Inserted rows:" + stm.getUpdateCount());
						try( ResultSet res = stm.getGeneratedKeys()){
							while( res.next()) {
								System.out.println("new contact id:" + res.getInt(1));
							}
						}// try get generated keys
					}
				}// try ResultSet rset
				
				System.out.println("Choose (c)ommit or (r)ollback:");
				Scanner scan = new Scanner(System.in);
				char ans = scan.next().charAt(0);
				switch( ans) {
					case 'c': conn.commit();
							  System.out.println("Commit Work!");
							  break;
					default:
							  conn.rollback();
							  System.out.println("Rollback Work!");
							  break;
				}
			}// try Statement stm
		}
		catch(SQLException e) {
			System.out.println("SQL Code:" + e.getErrorCode());
			System.out.println("SQL State:" + e.getSQLState());
			System.out.println("SQL Message:" + e.getMessage());
			e.printStackTrace();
			if( conn != null) {
				conn.rollback();
			}
		}
		finally {
			if( conn != null ) {
				conn.close();
			}
		}
		
	}	
}