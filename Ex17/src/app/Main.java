package app;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		String [] names = {"Anna","Maria","John"}; 
		//String [] names = {"Anna","Smith","anna@no.com"}; //това не е правилно
		
		int [] m; //декларация
		Random rnd = new Random(1);//псевдо случайни числа
		
		//инициализация на масива
		m = new int[5];
		
		System.out.println("Initial array:");
		for( int i = 0 ; i < m.length ; i++) {
			m[i] = rnd.nextInt(100);
			System.out.println("m[" + i + "]=>" + m[i] );
		}
		//---- Sort     ----
		for( int i = 0 ; i < m.length-1; i++) {
			for( int j = i+1; j < m.length; j++ ) {
				if ( m[i] > m[j]) {
					int t = m[i];
					m[i] = m[j];
					m[j] = t;
				}
			}
		}
		//---- End Sort ---
		System.out.println("Sorted array:");
		for( int i = 0 ; i < m.length ; i++) {
			System.out.println("m[" + i + "]=>" + m[i] );
		}
		
	}

}
 