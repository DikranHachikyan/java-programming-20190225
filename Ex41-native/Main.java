package app;

public class Main{

	public native long fact( int n);

	public static void main(String[] args) {
		System.out.println( new Main().fact(5));	
	}

	static {
		System.loadLibrary("main");
	}
}