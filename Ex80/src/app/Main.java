package app;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		String s = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n";
		byte [] buf = s.getBytes();
		try(FileOutputStream fout = new FileOutputStream("./output.txt",true)){
			fout.write(buf);
		}
		catch( IOException e) {
			e.printStackTrace();
		}
		
	}	
}


