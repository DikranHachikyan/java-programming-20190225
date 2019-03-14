package app;

public class Main {
		
	public static void main(String[] args) {
		System.out.println("begin main");
		Server.connect();
		Server s = new Server();
		s.show();
		Server s2 = new Server();
		s2.show();
		System.out.println("end main");
	}
	
	static {
		System.out.println("static section");
	}
}

class Server{
	static class ServerConfig{
		private static int port = 8080;
		private static String host = "127.0.0.1";
	}
	
	public Server() {
		System.out.println("Ctor Server");
	}
	
	public static void connect() {
		System.out.println("Connect to " + ServerConfig.host + " on port " + ServerConfig.port );
	}
	
	public void show() {
		System.out.println("Listen on " + ServerConfig.host + ":" + ServerConfig.port + "...");
	}
	
	public synchronized boolean login() {
		return true;
	}
	
	static {
		System.out.println("static section in class Server");
	}
}