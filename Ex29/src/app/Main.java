package app;

import text.ReadText;

public class Main {

	public static void main(String[] args) {
		ReadText rt = new ReadText();
		String txt = "";
		try {
			System.out.print("Type a text:");
			txt = rt.get();
			System.out.println("Text:" + txt);
		}
		catch( java.io.IOException e) {
			//e.printStackTrace();
			System.err.println("Exception:" + e.getMessage());
		}
	}

}
 