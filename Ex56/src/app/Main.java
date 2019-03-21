package app;

public class Main {
		
	public static void main(String[] args){
		Integer [] numbers = {11,3,9,2,14};
		Character [] chrs = {'m','v','e','s'};
		ArrayActions<?> array;
		
		array = new Array<Integer>(numbers);
		System.out.println("int array min:" + array.min() + " max:" + array.max());
		
		array = new Array<Character>(chrs);
		System.out.println("chrs array min:" + array.min() + " max:" + array.max());
		
	}
}

interface ArrayActions<T extends Comparable<T> > {
	public T min();
	public T max();
}

class Array<T extends Comparable<T>> implements ArrayActions<T>{
	private T [] values;

//Вариант 1
	
	public Array( T [] values) {
		this.values = values;
	}

//Вариант 2
	public Array( int size) {
		//Error
		//this.values = new T[size];
		Object [] els = new Object[size];
		this.values = (T[])els;
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