package app;

import java.util.ArrayList;

public class Main {
		
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<>();
		
		list.ensureCapacity(10);
		
		System.out.println("Initial Capacity:" + list.size());
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add(2, "Z");
		
		System.out.println("Elements:" + list);
		System.out.println("Size:" + list.size() );
		
		list.remove("C");
		System.out.println("Size:" + list.size() );
		
		for(final String s:list) {
			System.out.println(s);
			
		}	
	}
	
	
}


