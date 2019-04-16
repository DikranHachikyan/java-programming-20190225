package app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
	
	public static void main(String[] args) {
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			
			System.out.println("begin:" + Thread.currentThread().getName());
			
			Future<Integer> result = service.submit( ()->{
				int suma=1;
				for(int i = 2; i <= 100 ; i++) {
					suma += i;
				}
				Thread.sleep(2000);
				return suma;
			});
			
			while( !result.isDone()) {
				System.out.print(".");
			}
			int sum = result.get(1, TimeUnit.SECONDS);
			
			System.out.println();
			System.out.println("end:" + sum);
			
		}
		catch( InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		finally {
			if( service != null) service.shutdown();
		}
		
	}	
}