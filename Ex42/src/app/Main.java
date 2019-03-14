package app;

import draw.Point;
import draw.Rectangle;
import draw.Shape;

public class Main {
		
	public static void main(String[] args) {
		Shape [] shapes = { new Point(10,20), new Rectangle(50, 30, 130,140), new Server()};
		
		for( Shape s: shapes) {
			s.moveTo(120, -30);
			s.redraw();
			System.out.println("------------------------------");
		}
	}
	
	
}


class Server implements Shape{

	@Override
	public void moveTo(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(int dw, int dh) {
		// TODO Auto-generated method stub
		
	}
	
}