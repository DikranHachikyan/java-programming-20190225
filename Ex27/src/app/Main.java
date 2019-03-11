package app;

import draw.Point;

public class Main {

	public static void main(String[] args) {
		Point p1 = new Point(12,5);
		Point p2 = new Point(2,5);
		
		if( ! p1.equals(p2)) {
			System.out.println(p1 + "<>" + p2.toString());
		}
		else {
			System.out.println(p1 + "==" + p2);
			
		}
	}

}
 