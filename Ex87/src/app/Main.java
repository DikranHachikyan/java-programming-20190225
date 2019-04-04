package app;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Main {
		
	public static void main(String[] args){
		String s = "Lorem ipsum #dolor sit #amet, consectetur #adipisicing elit";
		byte [] buf = s.getBytes();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		int c = 0;
		
		try( PushbackInputStream pbis = new PushbackInputStream(bis)){
			while( (c = pbis.read()) != -1 ){
				if( c == '#') {
					pbis.unread('|');
					continue;
				}
				System.out.print((char)c);
			}//while
			System.out.println();
			System.out.println("Push Back mark supported:" + pbis.markSupported());
//			pbis.reset();
//			while( (c = pbis.read()) != -1 ){
//				System.out.print((char)c);
//			}//while
//			System.out.println();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		bis.reset();
		while( (c = bis.read() ) != -1) {
			System.out.print( (char)c);
		}
		System.out.println();
	}	
}


