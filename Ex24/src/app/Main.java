package app;

import draw.Point;

public class Main {

	public static void main(String[] args) {
		
		Point p = new Point(-1,2);
		Point tmp = new Point();
		
		p.draw();
		tmp.draw();
		
		p.setX(120);
		p.setY(230);
		
		p.draw();

	}

}
 