package app;


import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		System.out.println("begin");
		
		service.execute(new Producer(exchanger));
		service.execute(new Consumer(exchanger));
		
		service.shutdown();
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

class Producer implements Runnable{
	private Exchanger<String> exchanger;
	private String text = "";
	
	public Producer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		char c = 'A';
		
		for( int j = 0 ; j < 5; j++) {
			for( int i = 0 ; i < 5; i++) {
				text += c++;
			}
			try {
				System.out.println("sent:" + text);
				text = exchanger.exchange(text);
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
}

class Consumer implements Runnable{
	private Exchanger<String> exchanger;
	private String text = "";
	
	public Consumer( Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}
	
	
	@Override
	public void run() {
		for( int j = 0 ; j < 5 ; j++) {
			try {
				System.out.println("waiting ...");
				text = exchanger.exchange(text);
				System.out.println("received:" + text);
				text = "";
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
}