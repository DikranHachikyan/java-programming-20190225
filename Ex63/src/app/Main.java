package app;

public class Main {
		
	public static void main(String[] args){
		String input = "Lorem ipsum dolor";
		
		System.out.println("output:" + modifyString(input, (str)->str.toUpperCase()));
		
	}
	
	public static String modifyString(String str, IStringOperation op ) {
		return op.func(str);
	}
}

interface IStringOperation {
	public String func(String s);
}