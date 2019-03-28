package chat;

public class Message {
	private String text;
	//private User sender;
	
	public Message(String text) {
		setText(text);
	}
	
	public void setText(String text ) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
