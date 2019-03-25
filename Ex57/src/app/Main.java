package app;

import java.util.Scanner;

import chat.*;
import java.util.Deque;
import java.util.Random;
public class Main {
		
	public static void main(String[] args) throws InterruptedException {
		new App().start();
	}
	
}


class App{
	public void start() throws InterruptedException {
		ChatRoom chat = new ChatRoom("Java Programming");
		User [] users = new User[] {
			new User("Anna"),
			new User("Maria"),
			new User("John"),
			new User("Mark")
		};
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		Runnable runChat = new Runnable() {
			@Override
			public void run() {
				while( true ) {
					int counter = rand.nextInt(users.length);
					User t = users[ counter ];
					
					showMessages(chat);
					System.out.print(t.getUserName() + ">");
					String message = scan.nextLine();
					
					UserMessage userMessage = new UserMessage(t, new Message(message));
					chat.addUserMessage(userMessage);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread th = new Thread( runChat);
		th.start();
		th.join();
		
	}
	
	public  void showMessages(ChatRoom room) {
		Deque<UserMessage> messages = room.getUserMessages();
		for( UserMessage um: messages ) {
			System.out.println(um.toString());
		}
	}
}
