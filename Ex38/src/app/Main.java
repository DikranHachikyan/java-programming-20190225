package app;

public class Main {
		
	public static void main(String[] args) {
		Server.connect();
		Server s = new Server();
		s.show();
	}

}

class Server{

	private static int port = 8080;
	private static String host = "127.0.0.1";
	
	public static void connect() {
		System.out.println("Connect to " + host + " on port" + port );
	}
	
	public void show() {
		System.out.println("Listen on " + host + ":" + port + "...");
	}
}