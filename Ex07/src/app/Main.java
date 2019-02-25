package app;

public class Main {

	public static void main(String[] args) {
		double value = Math.random() * 100;
		String output = "";
		
		if( value > 50) {
			output = "value > 50:";
		}
		else {
			output = "value <=50:";
		}
		System.out.println(output +  "[" + value + "]");
		
	}

}
 