package app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		ExecutorService service = Executors.newFixedThreadPool(3);
		int currentPhase = 0;

		System.out.println("Start processing ...");
		
		service.submit( new Service(phaser, "A"));
		service.submit( new Service(phaser, "B"));
		service.submit( new Service(phaser, "C"));
		
		System.out.println("1 registered parties:" + phaser.getRegisteredParties());
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase:" + currentPhase + " completed...");
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase:" + currentPhase + " completed...");
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase:" + currentPhase + " completed...");
		
		phaser.arriveAndDeregister();
		
		
		if( phaser.isTerminated()) {
			System.out.println("End Processing...");
		}
		
		service.shutdown();
		System.out.println("2 registered parties:" + phaser.getRegisteredParties());
		
		try {
			if( !service.awaitTermination(20, TimeUnit.SECONDS)) {
				service.shutdownNow();
			}
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		
	}	
}


class Service implements Runnable{
	private Phaser phaser;
	private String name;
	
	public Service(Phaser phaser , String name) {
		this.phaser = phaser;
		this.name = name;
		//!!
		System.out.println("Register:" + name + " " + phaser.register() 
						   + " (" + phaser.getRegisteredParties() + ")");
	}
	@Override
	public void run() {
		//1
		System.out.println("Thread: " + name + " (phase 0)");
		try {
			Thread.sleep( (long)(200 * Math.random()) + 7 );
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		phaser.arriveAndAwaitAdvance();
		//1
		System.out.println("Thread:" + name + " (phase 1)");
		try {
			Thread.sleep( (long)(3000 * Math.random()) + 7 );
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		phaser.arriveAndAwaitAdvance();
		//2
		System.out.println("Thread:" + name + " (phase 2)");
		try {
			Thread.sleep( (long)(1000 * Math.random()) + 7 );
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("Deregister:" + name + " " + phaser.arriveAndDeregister());
	}
	
}
