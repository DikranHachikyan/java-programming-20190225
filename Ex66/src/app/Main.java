package app;

public class Main {
		
	public static void main(String[] args){
		Integer [] numbers = {1, 12, 8, 41, 8, 6, 7, 8, 9, 10};
		String  [] names = {"Anna","Markus","John","Maria"};
		
		ArrayUtils<String> su = new ArrayUtils<>();
		ArrayUtils<Integer> iu = new ArrayUtils<>();
		
		
		System.out.println("index of John:" + arrayActions(names, "John", su::<String>find));
		System.out.println("index of 41:" + arrayActions(numbers, 41, iu::<Integer>find));
		
		System.out.println("elements eql to 8:" + arrayActions(numbers, 8, ArrayUtils::<Integer>countEquals));
	}
	
	public static <T> int arrayActions(  T [] values, T element, IArrayUtils<T> utils) {
		return utils.run( values, element);
	}
}

interface IArrayUtils<T> {
	public int run( T [] values, T element);
}

class ArrayUtils<T> {
	
	public static <E> int countEquals( E [] values , E value) {
		int count = 0;
		for( E v : values) {
			if( v.equals(value) ) count++;
		}
		return count;
	}
	
	public int find( T [] values , T value) {
		for( int i = 0 ; i < values.length ; i++ ) {
			if( values[i] == value) return i;
		}
		return -1; //няма такъв
	}
}
