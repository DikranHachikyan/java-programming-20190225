package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Customer;
import db.Order;


public class Main {
	
	public static void main(String[] args) throws SQLException {
		//jdbc:mysql://localhost:3006/northwind?user=user-name&password=pass
		String url = "jdbc:mysql://localhost:3306/";
		String db  = "northwind";
		String user = "student"; //Windows: root
		String password = "student"; //Windows: ""
	 
		try(Connection conn = DriverManager.getConnection(url + db , user,password)) {
			Customers customers = new Customers(conn);
			OrdersCustomers ordersCustomers = new OrdersCustomers(conn);
			
			customers.read(" customerid IN ('ALFKI','PARIS','FISSA','BOLID')");
			
			ordersCustomers.read( customers.getCustomers());

			Map<Customer, List<Order> > orders = ordersCustomers.getOrders();
			
			System.out.println("Found " + customers.size() + " customer(s)");
			for( final Customer c: orders.keySet()) {
				System.out.println("------  " + c + " (" + orders.get(c).size() + ") -----------");
				for( final Order order: orders.get(c) ) {
					System.out.println("  " + order.getOrderId() + "|" + order.getOrderDate());
					
				}
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
/**
 * 
 * @author wizard
 *
 */
class OrdersCustomers {
	private final Map<Customer, List<Order>> orders = new HashMap<>();
	private String sql = "SELECT orderid\n" + 
						", orderdate\n" + 
						", customerid\n" + 
						"FROM orders\n";
	private Connection conn = null;
	
	public OrdersCustomers(Connection connection) {
		this.conn = connection;
	}
	
	public void read( List<Customer> customers /*, String where*/) throws SQLException {
		this.sql += "WHERE customerid = ?" ;// + where; 
		try(PreparedStatement pstm = this.conn.prepareStatement(this.sql)){
			this.orders.clear();
			for(final Customer c: customers) {
				pstm.setString(1, c.getCustomerId());
				try(ResultSet res = pstm.executeQuery()){
					List<Order> custOrders = new ArrayList<>();
					while(res.next()) {
						Order order = new Order();
						order.setOrderId( res.getInt("orderid"));
						order.setOrderDate( res.getObject("orderdate", java.sql.Date.class));
						order.setCustomerId( res.getString("customerid"));
						//order.setCustomerId(c.getCustomerId());
						custOrders.add(order);
					}
					this.orders.put( c, custOrders);
					
					
				}
			}
		}
	}
	
	public Map<Customer, List<Order>> getOrders(){
		return this.orders;
	}
}
/**
 * 
 * @author wizard
 *
 */

class Customers{
	private final List<Customer> customers = new ArrayList<>();
	private String sql = "SELECT customerid\n" + 
							", companyname\n" + 
							", contactname\n" + 
							", country\n" + 
							"FROM customers\n" +
							"WHERE 1=1";
	private Connection conn = null;
	
	public Customers(Connection connection) {
		this.conn = connection;
	}
	
	public void read(String where) throws SQLException{
		String query = this.sql + ((where != null && where.trim().length() > 0 )?
								    " AND " + where : "");
		try( Statement stm = conn.createStatement();
			 ResultSet res = stm.executeQuery(query)){
			 
			 this.customers.clear();
			 while( res.next()) {
				 Customer c  = new Customer();
				 c.setCustomerId(  res.getString("customerid"));
				 c.setCompanyName( res.getString("companyname"));
				 c.setContactName( res.getString("contactname"));
				 c.setCountry(     res.getString("country"));
				 this.customers.add(c);
			 }
			
		}
	}
	
	public int size() {
		return this.customers.size();
	}
	
	public List<Customer> getCustomers(){
		return this.customers;
	}
}



