package app;

public class Main {
		
	public static void main(String[] args){
		Integer [] numbers = {11,3,9,2,14};
		Character [] chrs = {'m','v','e','s'};
		
		Array<?> intArr = new Array<Integer>(numbers);
		System.out.println("int array min:" + intArr.min() + " max:" + intArr.max());
		
		Array<Character> chrsArr = new Array<>(chrs);
		System.out.println("chrs array min:" + chrsArr.min() + " max:" + chrsArr.max());
		
	}
}

interface ArrayActions<T extends Comparable<T> > {
	public T min();
	public T max();
}

class Array<T extends Comparable<T>> implements ArrayActions<T>{
	private T [] values;
	
	public Array( T [] values) {
		this.values = values;
	}
	
	@Override
	public T min() {
		T val = values[0];
		
		for(T v : values) {
			if( v.compareTo( val ) < 0 ) {
				val = v;
			}
		}
		return val;
	}
	
	@Override
	public T max() {
		T val = values[0];
		for( T v : values ) {
			if( v.compareTo(val) > 0 ) {
				val = v;
			}
		}
		return val;
	}
}