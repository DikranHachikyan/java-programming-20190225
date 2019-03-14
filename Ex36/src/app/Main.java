package app;

public class Main {

	public static void main(String[] args) throws Exception{
		Singleton s1 = new Singleton();
		s1.show();
		
		Singleton s2 = new Singleton();
		s2.show();
	}

}

class Singleton{
	private static int count = 0;
	
	public Singleton() throws Exception{
		count++;
		if( count >= 2) throw new Exception("singleton exception");
	}
	
	public void show() {
		System.out.println("singleton object (count:" + count + ")");
	}
}