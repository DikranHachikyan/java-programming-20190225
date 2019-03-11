package app;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner( new File("./data.txt"))) {
			while( scan.hasNextInt()) {
				int i = scan.nextInt();
				System.out.println("i=" + i);
			}
		}
		catch( java.io.FileNotFoundException e) {
			e.printStackTrace();	
		}
		
	}

}
 