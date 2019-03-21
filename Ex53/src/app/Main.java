package app;

public class Main {
		
	public static void main(String[] args){
		Pair<Integer,String>  p1 = new Pair<>(10,"Anna Smith");
		Pair<Integer,Integer> p2 = new Pair<>(1,456);
		Pair<?,?>             p3 = new Pair<String,String>("JD","John Doe");
		
		if( p1 instanceof Pair<?,?>) {
			System.out.println(p1 + " is instance of Pair");
		}
		
		if( ! (p2 instanceof SmartPair<?,?>) ) {
			System.out.println(p2 + " is not instance of SmartPair");
		}
		//Error!
		//if( p1 instanceof Pair<Integer,String>) {
		//	
		//}
	}
}

class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair( K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public Pair() {
		this(null,null);
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return getValue() + " (" + getKey() + ")";
	}
}
class SmartPair<K,V> extends Pair<K,V>{
	
}
//Ok
//class SmartPair<K,V,E> extends Pair<K,V>{
//	
//}

//Ok
//class SmartPair<V,K> extends Pair<K,V>{
//	
//}

//Error
//class SmartPair<T,M> extends Pair<K,V>{
//	
//}

//Error
//class SmartPair<K> extends Pair<K,V>{
//	
//}