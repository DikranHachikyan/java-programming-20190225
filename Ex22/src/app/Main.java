package app;


public class Main {

	public static void main(String[] args) {
		
		draw.Point p = new draw.Point();
		java.awt.Point p2 = new java.awt.Point();
		
		p.setX(120);
		p.setY(230);
		
		System.out.println("Point (" + p.getX()+ ", " + p.getY() + ") is visible:" + p.isVisible());

	}

}
 