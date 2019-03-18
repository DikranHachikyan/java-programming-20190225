package app;

import draw.Point;
import draw.Shape;

public class Main {
		
	public static void main(String[] args){
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				for( int i = 0; i < 5; i++) {
					try {
						System.out.println("i=" + i);
						Thread.sleep(100);
					}
					catch( InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};// new Runnable
		
		new Thread(rn).start();
		
	}
}
