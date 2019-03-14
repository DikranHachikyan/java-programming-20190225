package app;

public class Main {
	private String title;
	
	public Main(String title) {
		this.title  = title;
	}
	
	public void show() {
		System.out.println("App:" + title);
	}
	
	public static void main(String[] args) {
			Main app = new Main("Java App");
			
			app.show();
	}

}

class Server{

	public static int port = 8080;
	
	public static void connect() {
		System.out.println("Connect to localhost");
	}
}