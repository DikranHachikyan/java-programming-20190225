package app;

public class Main {

	public static void main(String[] args) {
		//1 + 2 + 3 + ... + 99 + 100 = 5050 
		int suma = 0;
		
		
		for( int i = 1; i <= 100; i++ ) {
			suma += i;
		}
		
		System.out.println("1 + 2 + 3 + ... + 99 + 100 = " + suma);
	}

}
 