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
		Counter cntr = new Counter();
		//---------------- task 1 ------------------------
		tasks.add( ()->{
			cntr.incrementAndPrint();
			return null;
		});
		//---------------- task 2 ------------------------
		tasks.add( ()->{
			cntr.incrementAndPrint();
			return null;
		});
		//---------------- task 3 ------------------------
		tasks.add(()->{
			cntr.incrementAndPrint();						
			return null;
		});
		//---------------- task 4 ------------------------
		tasks.add( ()->{
			cntr.incrementAndPrint();
			return null;
		});
		//------------------------------------------------
		System.out.println("begin");
		try {
			service.invokeAll(tasks);			
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			service.shutdown();
		}
		System.out.println("end");
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
//Thread UnSafe
class Counter{
	private int count = 0;
	
	public void incrementAndPrint() throws InterruptedException{
		Thread.sleep(10);
		count++;
		System.out.println(count + "->" + Thread.currentThread().getName());
	}
}
