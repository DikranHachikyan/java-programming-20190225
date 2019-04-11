package app;

import java.nio.ByteBuffer;

public class Main {
	public static final int CAPACITY = 250;
	
	public static void main(String[] args) {
		String s = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
		byte [] buf = s.getBytes();
		
		ByteBuffer org = ByteBuffer.wrap(buf);
		ByteBuffer copy = ByteBuffer.allocate(CAPACITY);
		
		System.out.println("org: pos=" + org.position() + 
				           " lim="     + org.limit()    + 
				           " cap="     + org.capacity());
		//copy.limit(org.limit());
		System.out.println("copy: pos=" + copy.position()+
						   " lim="      + copy.limit()   + 
						   " cap="      + copy.capacity());
		byte c;
		while( org.hasRemaining()) {
			c = org.get();
			copy.put(c);
			System.out.print(org.position() + ":" + (char)c + "|");
		}
		System.out.println();
		System.out.println("org: pos=" + org.position() + 
		           " lim="     + org.limit()    + 
		           " cap="     + org.capacity());

		System.out.println("copy: pos=" + copy.position()+
						   " lim="      + copy.limit()   + 
						   " cap="      + copy.capacity());
		copy.flip();
		//copy.rewind();
		
		System.out.println("copy: pos=" + copy.position()+
				" lim="      + copy.limit()   + 
				" cap="      + copy.capacity());
		
		while( copy.hasRemaining()) {
			c = copy.get();
			System.out.println(c + "|");
		}
		System.out.println();
		System.out.println("copy: pos=" + copy.position()+
				" lim="      + copy.limit()   + 
				" cap="      + copy.capacity());
		
	}	
}