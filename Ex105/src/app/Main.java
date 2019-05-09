package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		List< Callable<Integer> > tasks = new ArrayList<>();
		
		//---------------- task 1 ------------------------
		tasks.add( ()->{
			int fact = 1;
			System.out.println(Thread.currentThread().getName()+ " Calculate Factorial:");
			for( int i = 2 ; i <= 5; i++ ) {
				fact *= i;
				Thread.sleep(10);
			}
			return fact;
		});
		//---------------- task 2 ------------------------
		tasks.add( ()->{
			int suma = 1;
			System.out.println(Thread.currentThread().getName()+ " Calculate sum:1..100");
			for( int i = 2; i <= 100 ; i++ ) {
				suma += i;
				//if (suma > 1000) throw new RuntimeException();
				Thread.sleep(2);
			}
			return suma;
		});
		//---------------- task 3 ------------------------
		tasks.add(()->{
			Random rand = new Random();
			System.out.println(Thread.currentThread().getName()+ " Calculate Random Number:");
			int r = rand.nextInt(100);
			Thread.sleep(1200);
			return r;
		});
		//---------------- task 4 ------------------------
		tasks.add( ()->{
			int suma = 2;
			System.out.println(Thread.currentThread().getName()+ " Calculate sum:2+4+...+98+100");
			for( int i = 4; i <= 100 ; i+= 2 ) {
				suma += i;
				Thread.sleep(2);
			}
			return suma;
		});
		//------------------------------------------------
		System.out.println("begin");
		try {
			for( Callable<?> c: tasks) {
				Future<?> result = service.submit(c);
				System.out.println("result:" + result.get());
			}
		}
		catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		try {
			if( !service.awaitTermination(10, TimeUnit.SECONDS)) {
				service.shutdown();
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

