package app;

public class Main {
		
	public static void main(String[] args){
		float  m1 = 4.5F;
		double m2 = 4.4;
		
		IComputable<Integer> fact = (n)->{
			int res = 1;
			for( int i = 1; i <= n ; i++ ) {
				res *= i; 
			}
			return res;
		};
		
		IComputable<Double> avg = (n)->{
			//1+2+3+4 ... n/n
		
			int sum = 0;
			for(int  i = 1 ; i <=n ; i++ ) {
				sum +=i;
			}
			return sum/n;
		};
		System.out.println("3!=" + fact.calculate(3));
		System.out.println("5!=" + fact.calculate(5));
		System.out.println("Avg 1->5 =" + avg.calculate(5D));
	}
}

interface IComputable<T> {
	public T calculate(T n);
}