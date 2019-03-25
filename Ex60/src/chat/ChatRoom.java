package chat;

import java.util.ArrayDeque;
import java.util.Deque;

public class ChatRoom {
	private String roomName;
	
	private ArrayDeque<UserMessage> userMessages;
	
	public ChatRoom(String roomName) {
		setRoomName(roomName);
		userMessages = new ArrayDeque<>();
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void addUserMessage( UserMessage userMessage) {
		userMessages.addLast(userMessage);
	}
	
	public Deque<UserMessage> getUserMessages(){
		return userMessages;
	}
}
