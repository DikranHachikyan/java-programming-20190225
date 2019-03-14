package app;

public class Main {
		
	public static void main(String[] args) {
		Server.connect();
		Server s = new Server();
		s.show();
	}

}

class Server{
	static class ServerConfig{
		private static int port = 8080;
		private static String host = "127.0.0.1";
	}
	public static void connect() {
		System.out.println("Connect to " + ServerConfig.host + " on port" + ServerConfig.port );
	}
	
	public void show() {
		System.out.println("Listen on " + ServerConfig.host + ":" + ServerConfig.port + "...");
	}
}