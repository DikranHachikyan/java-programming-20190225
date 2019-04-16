package app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
				return suma;
			});
			
			int sum = result.get();
			
			System.out.println("end:" + sum);
			
		}
		catch( InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		finally {
			if( service != null) service.shutdown();
		}
		
	}	
}