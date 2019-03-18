package app;

import draw.Point;
import draw.Shape;

public class Main {
		
	public static void main(String[] args){
		Shape sh = new Point();
		
		Shape sp = new Shape() {
			String name = "Circle";
			@Override
			public void moveTo(int dx, int dy) {
				System.out.println("move to method");
			}
			
			@Override
			public void redraw() {
				System.out.println("redraw method");				
			}
			
			@Override
			public void scale(int dw, int dh) {
				System.out.println("scale method");								
			}
		};
		
		sp.redraw();
		
	}
}
