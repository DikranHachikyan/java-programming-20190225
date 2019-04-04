package app;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		ByteArrayInputStream bin;
		byte [] buf = {0};
		
		try( FileInputStream fis = new FileInputStream("./readme.txt")){
			buf = new byte[fis.available()];
			fis.read(buf);
		}
		catch( IOException e) {
			e.printStackTrace();
		}
		System.out.println("buffer:" + new String(buf));
		System.out.println("------");
		bin = new ByteArrayInputStream(buf);
		int c;
		while( (c = bin.read()) != -1) {
			System.out.print((char)c);
		}
		System.out.println();
	}	
}


