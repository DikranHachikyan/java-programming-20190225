package app;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(SharedResource.NITTER);
		UpCounter	up = new UpCounter(cdl, "Up");
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		System.out.println("begin");
		//Task 1
		service.submit(()->{
			try {
				up.count();				
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		//Task 2
		service.submit(()->{
			try {
				System.out.println("process other data...");
				Thread.sleep(100);
				System.out.println("wait task1 to finish...");
				cdl.await();
				System.out.println("Task 2: Result from Task1:" + SharedResource.count);
				
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		});
		try {
			cdl.await(); //спира и чака брояча да стане 0
			service.shutdown();
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		try {
			if( !service.awaitTermination(20, TimeUnit.SECONDS)) {
				service.shutdownNow();
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

class SharedResource {
	public static int NITTER = 10;
	public static int count = 0;
}

class UpCounter{ 
	private CountDownLatch latch;
	private String name;
	
	public UpCounter( CountDownLatch latch, String name) {
		this.latch = latch;
		this.name = name;
	}
	
	public void count() throws InterruptedException{
		for( int i = 0; i < SharedResource.NITTER; i++) {
			System.out.println(name + ":" + (++SharedResource.count));
			latch.countDown();
			Thread.sleep(30);
		}		
		System.out.println(name + " released the lock");
		//async non-critical section
	}
}
