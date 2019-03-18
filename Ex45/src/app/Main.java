package app;

public class Main {
		
	public static void main(String[] args){
		System.out.println("start of main thread");
		MyThread mt = new MyThread();
		MyRunnableThread mtr = new MyRunnableThread();
		
		System.out.println("stop of main thread");
	}
}

//-------- Implements Runnable  -----------
class MyRunnableThread implements Runnable{
	
	public MyRunnableThread() {
		super();//Object
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		System.out.println("start of thread (implements)");
		for( int i = 0 ; i < 5 ; i++) {
			System.out.println("child thread (implements):" + i);
			try {
				Thread.sleep(1000);
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("stop of thread (implements)");
	}
}

// ------- Extends Thread ------------------
class MyThread extends Thread {
	public MyThread() {
		super(); // Thread
		setPriority(Thread.MIN_PRIORITY);
		start();
	}
	
	@Override
	public void run(){
		System.out.println("start of child thread (extends)");
		for( int i = 0; i < 5 ; i++ ) {
			System.out.println("child thread (extends):" + i);
			try {
				Thread.sleep(1000); //1 s				
			}
			catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of child thread (extends)");
	}
}