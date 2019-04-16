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
		ExecutorService service = null;
		List< Callable<Integer> > tasks = new ArrayList<>();
		
		//---------------- task 1 ------------------------
		tasks.add( ()->{
			int fact = 1;
			System.out.println("Calculate Factorial:");
			for( int i = 2 ; i <= 5; i++ ) {
				fact *= i;
				Thread.sleep(10);
			}
			return fact;
		});
		//---------------- task 2 ------------------------
		tasks.add( ()->{
			int suma = 1;
			System.out.println("Calculate sum:1..100");
			for( int i = 2; i <= 100 ; i++ ) {
				suma += i;
				Thread.sleep(2);
			}
			return suma;
		});
		//---------------- task 3 ------------------------
		tasks.add(()->{
			Random rand = new Random();
			System.out.println("Calculate Random Number:");
			int r = rand.nextInt(100);
			Thread.sleep(1200);
			return r;
		});
		//---------------- task 4 ------------------------
		tasks.add( ()->{
			int suma = 2;
			System.out.println("Calculate sum:2+4+...+98+100");
			for( int i = 4; i <= 100 ; i+= 2 ) {
				suma += i;
				Thread.sleep(2);
			}
			return suma;
		});
		//------------------------------------------------
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			
			List< Future<Integer>> results = service.invokeAll(tasks, 300, TimeUnit.MILLISECONDS);
			
			for( Future<?> ft: results) {
				if( !ft.isCancelled()) {
					System.out.println("result:" + ft.get());
				}
			}
			
			
			System.out.println("end");
			
		}
		catch( InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		finally {
			if( service != null ) service.shutdown();
		}
	}	
}