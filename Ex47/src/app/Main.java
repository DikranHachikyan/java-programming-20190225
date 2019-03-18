package app;

public class Main {
		
	public static void main(String[] args) throws InterruptedException{
		System.out.println("start of main thread");
		Token token = new Token();
		Sender s = new Sender(token);
		Receiver r = new Receiver(token);
		
		s.getThread().join();
		r.getThread().join();
		
		System.out.println("stop of main thread");
	}
}
/*
 * Sender
 */
class Sender implements Runnable{
	private Token token;
	private Thread thread;
	
	public Sender( Token token) {
		super();
		this.token = token;
		thread = new Thread(this);
		thread.setName("Sender Thread");
		thread.start();
	}
	
	@Override
	public void run() {
		int i = 1;
		while( i <= 10 ) {
			try {
				token.put(i);
				System.out.println("Sent:" + i);
				Thread.sleep(1000);
				i++;
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public Thread getThread() {
		//System.out.println("Current Thread:" + Thread.currentThread().getName() );
		//return Thread.currentThread();
		//или
		return thread;
	}
}

/*
 * Receiver
 */
class Receiver implements Runnable{
	private Token token;
	private Thread thread;
	
	public Receiver( Token token) {
		super();
		this.token = token;
		
		thread = new Thread(this);
		thread.setName("Receiver Thread");
		thread.start();
	}
	
	@Override
	public void run() {
		int i = 0;
		
		while( i < 10) {
			try {
				i = token.get();
				System.out.print("Received:" +  i+ " ");
				Thread.sleep(1000);				
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Thread getThread() {
		//System.out.println("Current Thread:" + Thread.currentThread().getName());
		//return Thread.currentThread();
		//или
		return thread;
	}
}

/*
 * Token
 */
class Token {
	private int n;
	private boolean valueSet = false;
	
	public synchronized int get() {
		while( !valueSet) {
			try {
				wait();				
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
		valueSet = false;
		notify();
		return n;
	}
	
	public synchronized void put( int n) {
		while( valueSet) {
			try {
				wait();				
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.n = n;
		valueSet = true;
		notify();
	}
}