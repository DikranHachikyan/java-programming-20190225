package app;

import draw.*;

public class Main {

	public static void main(String[] args) {
		
		Point p = new Point();
		
		
		p.setX(120);
		p.setY(230);
		
		System.out.println("Point (" + p.getX()+ ", " + p.getY() + ") is visible:" + p.isVisible());

	}

}
 