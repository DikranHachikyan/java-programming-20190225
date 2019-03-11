package app;

public class Main {

	public static void main(String[] args) {
		Server srv = new Server(8080);
		
		System.out.println("Listen on port:" + srv.PORT);
	}

}

final class Server{
	//1. константа
	//2. може да не се задава начална стойност
	public final int PORT;
	
	public Server( int port) {
		PORT = port;
	}
	
	public final void connect() {
		System.out.println("Connect to localhost");
	}
}

//class WebServer extends Server{
//	public WebServer(int port) {
//		super(port);
//	}
//	
//	
//	 @Override public final void connect() {
//	  
//	 }
//	 
//}