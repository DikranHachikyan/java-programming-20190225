package app;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int [] m; //декларация
		Random rnd = new Random(1);//псевдо случайни числа
		
		//инициализация на масива
		m = new int[5];
		
		//инициализация на елементите
		for( int i = 0 ; i < m.length ; i++) {
			m[i] = rnd.nextInt(100);
		}
		
		for( int i = 0 ; i < m.length ; i++) {
			System.out.println("m[" + i + "]=>" + m[i] );
		}
		
	}

}
 