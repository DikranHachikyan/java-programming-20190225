package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		char [] buf = new char[128];
		int c = 0;
		
		try( FileReader frd = new FileReader("./readme.txt");
			 FileWriter fwt = new FileWriter("./readme1.txt")){
			while( (c = frd.read(buf)) != -1 ) {
				fwt.write(buf);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}	
}


