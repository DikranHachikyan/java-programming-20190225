package db;

public class Customer implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String companyName;
	private String contactName;
	private String country;
	
	public Customer() {
		setCustomerId("");
		setCompanyName("");
		setContactName("");
		setCountry("");
	}
	
	public final String getCustomerId() {
		return customerId;
	}
	public final void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public final String getCompanyName() {
		return companyName;
	}
	public final void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public final String getContactName() {
		return contactName;
	}
	public final void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public final String getCountry() {
		return country;
	}
	public final void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public boolean equals(Object ob) {
		if( ob == null || !(ob instanceof Customer) ) return false;
		Customer c = (Customer)ob;
		return c.getCustomerId().equals(getCustomerId());
	}
	
	@Override
	public String toString() {
		return getCompanyName() + " [" + getCustomerId()+ "]";
	}
}
