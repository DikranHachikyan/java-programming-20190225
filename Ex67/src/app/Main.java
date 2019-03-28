package app;

import java.util.Random;
import java.util.Arrays;

public class Main {
		
	public static void main(String[] args){
		Random rand = new Random();
		int [] array = new int[10];
		rand.setSeed(1);
		//1. запълване със стойности
		Arrays.fill(array, 11);
		show(array);
		//2.
		Arrays.parallelSetAll(array, (a)->rand.nextInt(100));
		show(array);
		
		//3.sort
		Arrays.sort(array);
		show(array);
		
		int key = Arrays.binarySearch(array, 3);
		System.out.println("3 found at index:" + key);
		
		//3. parallel prefix
		Arrays.parallelPrefix(array, (a,b)->a+b);
		show(array);
	}
	
	public static void show( int [] array) {
		for( int v : array) {
			System.out.print(v + "|");
		}
		System.out.println();
	}
}

