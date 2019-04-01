package app;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		int size = 0;
		try(FileInputStream fin = new FileInputStream("./readme.txt")) {
			size = fin.available();
			System.out.println("size:" +size + " bytes");
			
			int n = size >> 2; // деление на 4
			System.out.println("Reading first " + n + " bytes");
			for( int i = 0 ; i < n ; i++ ) {
				System.out.print((char)fin.read());
			}
			
			System.out.println();
			System.out.println("available:" + fin.available() + " bytes");
			
			byte [] buffer = new byte[n]; //следващи 111
			fin.read(buffer);
			System.out.println( new String( buffer, 0, buffer.length));
			fin.skip(n); // пропускаме 111 байта
			
			fin.read(buffer);
			System.out.println("next bytes:" + new String(buffer, 0, buffer.length));
			System.out.println("remaining:" + fin.available());
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}	
}


