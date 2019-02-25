package app;

public class Main {

	public static void main(String[] args) {
		//1 + 2 + 3 + ... + 99 + 100 = 5050 
		int suma = 0;
		int i = 1;
		
		while( i <= 100 ) {
			suma += i; // suma = suma + i
			i++;       //!!! без този ред -> безкраен цикъл
		}
		
		System.out.println("1 + 2 + 3 + ... + 99 + 100 = " + suma);
	}

}
 