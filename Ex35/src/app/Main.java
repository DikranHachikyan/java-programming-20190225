package app;

public class Main {

	public static void main(String[] args) {
		System.out.println("1. Port:" + Server.port);
		
		Server s = new Server();
		System.out.println("2. Port:" + s.port);
		
		Server.port = 3000;
		
		Server s2 = new Server();
		System.out.println("3. Port:" + s.port);
		System.out.println("4. Port:" + s2.port);
		
		Server.connect();
	}

}

class Server{

	public static int port = 8080;
	
	public static void connect() {
		System.out.println("Connect to localhost");
	}
}