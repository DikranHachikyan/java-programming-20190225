package app;

public class Main {

	public static void main(String[] args) {
		int x = 2;
		int y = 0;
		
		y = x++;
		//1. y = x
		//2. x++
		
		System.out.println("x=" + x + " y=" + y);
		
		x = 2;
		
		y = ++x;
		//1. ++x
		//2. y = x
		
		System.out.println("x=" + x + " y=" + y);
		
		
	}

}
