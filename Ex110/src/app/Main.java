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
		ArrayCalculator aCalc = new ArrayCalculator();
		
		//---------------- task 1 ------------------------
		tasks.add( ()->{
			aCalc.sum();
			System.out.println("Sum elements:"+ aCalc.getResult());
			return null;
		});
		//---------------- task 2 ------------------------
		tasks.add( ()->{
			aCalc.mult();
			System.out.println("Multiply elelemts:" + aCalc.getResult());
			return null;
		});
		//---------------- task 3 ------------------------
//		tasks.add(()->{
//									
//			return null;
//		});
		//---------------- task 4 ------------------------
//		tasks.add( ()->{
//
//			return null;
//		});
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
//Thread Safe
class ArrayCalculator {
	private int [] data = new int[]{1, 2, 3, 4, 5};
	private int result = 0;
	//private int s = 0;
	private Object lock = new Object();
	
	public  void sum() throws InterruptedException {
		int s = 0;
		synchronized (lock) {
			for( int i = 0 ; i < data.length ; i++) {
				s += data[i];
				Thread.sleep(10);
			}
			result = s;			
		}
	}
	
	public  void mult() throws InterruptedException {
		int s = 1;
		synchronized (lock) {
			for( int i = 0 ; i < data.length ; i++) {
				s *= data[i];
				Thread.sleep(10);
			}
			result = s;			
		}
	}
	
	public synchronized int getResult() {
		return result;
	}
}