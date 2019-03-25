package app;

public class Main {
		
	public static void main(String[] args){
		Thread th = new Thread( ()->{
			int i = 0;
			while(i < 10) {
				System.out.println("i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
	});
		th.start();
	}
}
