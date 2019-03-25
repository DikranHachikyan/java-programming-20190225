package app;

public class Main {
		
	public static void main(String[] args){
		IRandomNumber num = new IRandomNumber() {
			@Override
			public double getValue() {
				return Math.random() * 100;
			}
		};
		
		System.out.println("Random 1:" + num.getValue());
		System.out.println("Random 2:" + num.getValue());
		System.out.println("Random 3:" + num.getValue());
	}
}

interface IRandomNumber {
	public double getValue();
}