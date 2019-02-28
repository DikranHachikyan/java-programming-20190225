package app;

public class Main {

	public static void main(String[] args) {
		int [] m; //декларация
		
		//инициализация
		m = new int[]{11,22,33,44,55,66};
		
		for( int i = 0 ; i < m.length ; i++) {
			System.out.println("m[" + i + "]=>" + m[i] );
		}
		
	}

}
 