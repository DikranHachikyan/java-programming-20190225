package app;

public class Main {
		
	public static void main(String[] args){
		Pair<String,String> ps = new Pair<>("JD","John Doe");
		System.out.println("Pair:" + ps);
		
		Integer num = 10; //boxing 
		// Integer num = new Integer(10)
		
		Pair<Integer,String> rm = new Pair<>(10,"X");
		System.out.println("Roman Number:" + rm);
		int key = rm.getKey();
		String val = rm.getValue();
		
		//Raw Type
		Pair pbase = new Pair("AS","Anna Smith");
		Pair raw   = new Pair( Integer.valueOf(9),"IX");
		
		String name = (String)pbase.getValue();
		System.out.println("Name:" + name);
		int intKey = (Integer)raw.getKey();
		System.out.println("Int key:" + intKey);
		
		Pair<Integer,Integer> pi = new Pair<>(10,20);
		System.out.println("Pi " + pi);
		
		//rm = pi; Error
		pbase = raw;
		System.out.println("PBase:" + pbase.getValue());
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