package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
	
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1, true);
		UpCounter up = new UpCounter(sem, "Up");
		DownCounter down = new DownCounter(sem,"Down");
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		//------------------------------------------------
		try {			
			System.out.println("begin");
			service.submit(()->{
				up.count();
				return null;
			});
			service.submit(()->{
				down.count();
				return null;
			});
			
			//тук ще чака
			System.out.println("Main Thread is waiting...");
			sem.acquire();
			service.shutdown();
			sem.release();
			
			System.out.println("end");
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------------
		try {
			if( !service.awaitTermination(10, TimeUnit.SECONDS)) {
				service.shutdownNow();
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

class SharedResource {
	public static int count = 0;
}

class UpCounter{
	private Semaphore semaphore;
	private String name;
	
	public UpCounter( Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;
	}
	
	public void count() throws InterruptedException{
		//async non-critical section
		System.out.println(name + " is waiting...");
		
		semaphore.acquire();
		//sync critical section
		for( int i = 0; i < 5; i++) {
			System.out.println(name + ":" + (++SharedResource.count));
			Thread.sleep(10);
		}
		semaphore.release();
		
		System.out.println(name + " released the lock");
		//async non-critical section
	}
}

class DownCounter{
	private Semaphore semaphore;
	private String name;
	
	public DownCounter( Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;
	}
	
	public void count() throws InterruptedException{
		//async non-critical section
		System.out.println(name + " is waiting...");
		
		semaphore.acquire();
		//sync critical section
		for( int i = 0; i < 5; i++) {
			System.out.println(name + ":" + (--SharedResource.count));
			Thread.sleep(10);
		}
		semaphore.release();
		
		System.out.println(name + " released the lock");
		//async non-critical section
	}
}