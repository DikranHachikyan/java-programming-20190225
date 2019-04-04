package app;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args){
		String s = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte [] buf = s.getBytes();
		
		try {
			
			bos.write(buf);
		}
		catch( IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("BAOS as String:" + bos);
		
		try( FileOutputStream fos = new FileOutputStream("./byte-array.txt")){
			bos.writeTo(fos);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		bos.write('X');
		System.out.println("BAOS as String:" + bos);
		bos.reset();
		bos.write('A');
		System.out.println("BAOS as String:" + bos);
		
		
	}	
}


