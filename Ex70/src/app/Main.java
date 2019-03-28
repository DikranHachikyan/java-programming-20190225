package app;

import java.util.LinkedList;
import draw.Shape;
import draw.Point;

public class Main {
		
	public static void main(String[] args){
		LinkedList<Shape> ls = new LinkedList<>();
		
		ls.add( new Point(10,20));
		ls.add( new Point(5,12));
		ls.add( new Point(30,40));
		
		Point p = new Point(5,12);
		
		if(ls.contains(p)) {
			System.out.println(p + " is in list:" + ls);
		}
		
	}
	
	
}


