package app;

public class Main {
	public static int z = 1;	
	public static void main(String[] args){
		int n = 5;
		IComputable fact = ()->{
			int res = 1;
			for( int i = 1; i <= n; i++) {
				res *= i;
			}
			//n++; Error!
			z++;
			return res;
		};
		
		System.out.println(n +" !=" + fact.calculate());
		System.out.println("z = " + z);
		
	}
}

interface IComputable {
	public double calculate();
}