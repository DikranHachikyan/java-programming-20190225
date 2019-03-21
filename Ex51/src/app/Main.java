package app;

import draw.Point;
import draw.Shape;

public class Main {
		
	public static void main(String[] args){
		Point circle = new Point() {
			@Override
			public void draw() {
				System.out.println("Draw Circle");
			}
		};
		
		circle.draw();
	}
}
