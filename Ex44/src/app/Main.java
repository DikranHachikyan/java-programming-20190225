package app;

public class Main {
		
	public static void main(String[] args) throws InterruptedException{
		Thread th = Thread.currentThread();
		
		System.out.println("Main Thread:" + th);
		
		th.setPriority(Thread.MAX_PRIORITY);
		th.setName("My Thread");

		System.out.println("Main Thread:" + th);
		
		for( int i = 0; i < 5; i++) {
			System.out.println("i=" + i);
			Thread.sleep(1000);
		}
	}
}
