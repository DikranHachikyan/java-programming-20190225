package chat;

public class UserMessage {
	private User user;
	private Message message;
	
	public UserMessage( User user, Message message) {
		setUser(user);
		setMessage(message);
	}
	
	public UserMessage() {
		this(null, null);
	}
	
	public void setUser(User user) {
		this.user = user; 
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public void setUser(String userName) {
		this.user = new User(userName);
	}
	
	public User getUser() {
		return user;
	}
	public Message getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return user.getUserName() + ":" + message.getText();
	}
}
