package app;

public class Main {

	public static void main(String[] args) {
		int option = 5;
		String res = "";
		
		switch( option ) {
			case 1: res += " Option 1";
					//break;
			case 2: res += " Option 2";
					//break;
			case 3: res += " Option 3";
					break;
			default:
				res += " Default Option";
		}
		System.out.println(res);
	}

}
 