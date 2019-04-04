package app;

import java.io.ByteArrayInputStream;

public class Main {
		
	public static void main(String[] args){
		String s = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod";
		byte [] buf = s.getBytes();
		boolean marked = false;
		
		ByteArrayInputStream bin = new ByteArrayInputStream(buf);
		int c;
		System.out.println("availeable:" + bin.available());
		while( (c = bin.read()) != -1) {
			if( (char)c == 'a' && !marked ) {
				bin.mark(0);
				marked = true;
			}
			System.out.print((char)c);
		}
		System.out.println();
		System.out.println("availeable:" + bin.available());
		bin.reset();
		System.out.println("availeable:" + bin.available());
		System.out.println("from marker to the end:");
		while( (c = bin.read()) != -1) {
			System.out.print((char)c);
		}
		System.out.println();
		bin.reset();
		System.out.println("availeable:" + bin.available());
		
	}	
}


