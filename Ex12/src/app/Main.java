package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		int value = 0;
		
		System.out.print("1. value = ");
		while( scan.hasNextInt() ) {
			value = scan.nextInt();
			System.out.println("2. value = " + value);
			System.out.print("1. value = ");
		}
		//scan.close();
	}

}
 