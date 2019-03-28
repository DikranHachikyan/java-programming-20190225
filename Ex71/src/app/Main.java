package app;

import java.util.TreeSet;

public class Main {
		
	public static void main(String[] args){
		TreeSet<String> ts = new TreeSet<>();
		
		ts.add("zoom");
		ts.add("one");
		ts.add("two");
		ts.add("three");
		ts.add("four");
		ts.add("two");
		
		System.out.println("Tree set:" + ts);
		System.out.println("Sub set four-two:" + ts.subSet("four", "two"));
	}
	
	
}


