package app;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService service = Executors.newFixedThreadPool(4);
		ServiceA sa = new ServiceA(barrier);
		ServiceB sb = new ServiceB(barrier);
		
		System.out.println("begin");
		
		service.execute(sa);
		service.execute(sb);
		
		try {
			System.out.println("Wait for services to complete...");
			barrier.await();
			service.shutdown();
		}
		catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		try {
			if( ! service.awaitTermination(20,TimeUnit.SECONDS)) {
				service.shutdownNow();
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
				
	}	
}

class ServiceA implements Runnable{
	
	private CyclicBarrier barrier;
	
	public ServiceA( CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		System.out.println("Starting service A...");
		try {
			System.out.println("Service A: process data...");
			Thread.sleep(3000);
		
		    System.out.println("Service A finished waiting for others...");
			barrier.await();			
		}
		catch( InterruptedException|BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Service A: waiting is over!");
	}
}

class ServiceB implements Runnable{
	
	private CyclicBarrier barrier;
	
	public ServiceB( CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		System.out.println("Starting service B...");
		try {
			System.out.println("Service B: process data...");
			Thread.sleep(5000);
		
		    System.out.println("Service B finished waiting for others...");
			barrier.await();			
		}
		catch( InterruptedException|BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Service B: waiting is over!");
	}
}