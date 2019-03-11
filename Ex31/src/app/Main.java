package app;

import text.ReadText;

public class Main {

	public static void main(String[] args) {
		ReadText rt = new ReadText();
		String txt = "";
		
		System.out.print("Type a text:");
		txt = rt.get();
		System.out.println("Text:" + txt);
		
	}

}
 