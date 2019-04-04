package app;

public class Main {
		
	public static void main(String[] args){
		System.out.println("length of args:" + args.length);
		
		for(String s: args) {
			System.out.println("arg:" + s);
		}
	}	
}


