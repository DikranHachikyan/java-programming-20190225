package app;

public class Main {
		
	public static void main(String[] args) throws InterruptedException{
		System.out.println("start of main thread");
		Message msg  = new Message();
		Caller  c1   = new Caller(msg, "first", "(",")");
		Caller  c2   = new Caller(msg, "second", "[","]");
		Caller  c3   = new Caller(msg, "third", "{","}");
		
		c1.getThread().join();
		c2.getThread().join();
		c3.getThread().join();
		System.out.println("stop of main thread");
	}
}

class Caller implements Runnable {
	private Thread th;
	private Message message ;
	private String text;
	private String lbr;
	private String rbr;
	
	public Caller( Message msg, String text, String lbr, String rbr) {
		this.message = msg;
		this.text = text;
		this.lbr = lbr;
		this.rbr = rbr;
		th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		//... async
		//System.out.println(lbr+"async before"+ rbr);
		synchronized (message) {
			message.show(text, lbr, rbr);			
		}
		//...async
		//System.out.println(lbr+"async after"+ rbr);
	}
	
	public Thread getThread() {
		return this.th;
	}
}

/*
 * Class Message
 */
class Message{
	public void show( String msg, String lbr, String rbr) {
		System.out.print(lbr + " " + msg);
		try {
			Thread.sleep(1000);			
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" " + rbr);
	}
}