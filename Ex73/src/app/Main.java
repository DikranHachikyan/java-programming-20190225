package app;


import java.util.Iterator;

import containers.ArrayQueue;

public class Main {
		
	public static void main(String[] args){
		ArrayQueue<String> que = new ArrayQueue<>(String.class, 5);
		
		que.add("1");
		que.add("2");
		que.add("3");
		que.add("4");
		System.out.println("Queue size:" + que.size());
		
		for( String s : que) {
			System.out.println("->" + s);
		}
		//-------------------------------------------
		System.out.println("with iterator:");
		
		Iterator<String> it = que.iterator();
		while( it.hasNext()) {
			System.out.println("it:" + it.next());
		}
		//-------------------------------------------
		
		String s = "";
		while(( s = que.poll()) != null) {
			System.out.println("s="+s);
		}
		System.out.println("Queue size:" + que.size());
	}
	
	
}


