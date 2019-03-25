package app;

public class Main {
		
	public static void main(String[] args){
		int x = 5;
		
		System.out.println(x + "! = " + calc( x , CMath::factorial )  );
		
		CMath cmath = new CMath();
		
		System.out.println("sum 1+2+ ... + 99 + 100=" + calc(100, cmath::sum));
		
		
		IComputable computable = cmath::sum;
		System.out.println("sum 1+2+ ... + 9 + 10=" + calc(10, computable));
		
	}
	
	public static int calc( int value, IComputable comp ) {
		return comp.calculate(value);
	}
}

interface IComputable {
	public int calculate(int n);
}

class CMath {
	public static int factorial(int n) {
		if( n > 1) {
			return n * factorial(n -1);
		}
		return 1;
	}
	//1+ 2+ 3+ 4 +.... n = (n * n + n)/2
	public int sum(int n) {
		return (n * n + n)>>1;
	}
}