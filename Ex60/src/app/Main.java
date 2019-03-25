package app;

public class Main {
		
	public static void main(String[] args){
		IComputable fact = (n)->{
			int res = 1;
			for( int i = 1; i <= n ; i++ ) {
				res *= i; 
			}
			return res;
		};
		
		IComputable avg = (n)->{
			//1+2+3+4 ... n/n
		
			int sum = 0;
			for(int  i = 1 ; i <=n ; i++ ) {
				sum +=i;
			}
			return sum/n;
		};
		System.out.println("3!=" + fact.calculate(3));
		System.out.println("5!=" + fact.calculate(5));
		System.out.println("Avg 1->5 =" + avg.calculate(5));
	}
}

interface IComputable {
	public double calculate(int n);
}