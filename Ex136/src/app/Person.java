package app;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Person() {
		this("","");
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
	

}
