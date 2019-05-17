package db;

import java.sql.Date;

public class Order implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private Date orderDate;
	private String customerId;
	
	public Order() {
		setOrderId(0);
		setOrderDate(null);
		setCustomerId("");
	}
	
	public final int getOrderId() {
		return orderId;
	}
	public final void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public final Date getOrderDate() {
		return orderDate;
	}
	public final void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public final String getCustomerId() {
		return customerId;
	}
	public final void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	//TODO: override toString(), equals()
	
	

}
