package app;

import java.util.LinkedList;

public class Main {
		
	public static void main(String[] args){
		LinkedList<Integer> ls = new LinkedList<>();
		
		ls.add(10);
		ls.add(20);
		ls.add(30);
		ls.add(40);
		
		ls.addFirst(1);
		ls.addLast(2);
		
		System.out.println("List:" + ls);
		
		Integer first = ls.removeFirst();
		Integer last  = ls.removeLast();
		System.out.println("List:" + ls);
		
		ls.set(2, last);
		System.out.println("List:" + ls);
		
		
	}
	
	
}


