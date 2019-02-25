package app;

public class Main {

	public static void main(String[] args) {
		//2 + 4 + ... + 98 + 100 
		int suma = 0;
		int i = 1;
		
		while( i <= 4 ) {
			i++;
			
			if ( (i % 2) != 0) continue;
			
			suma += i;
		}
		
		System.out.println("2 + 4 + ... + 98 + 100 = " + suma);
	}

}
 