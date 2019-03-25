package chat;

import java.util.UUID;

public class User {
	private UUID uid;
	private String userName;
	//private Message message;
	
	public User(String userName) {
		setUserName(userName);
		uid = UUID.randomUUID();
	}
	
	public User() {
		this("");
	}
	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public UUID getUid() {
		return uid;
	}
}
