package app;

public class Main {
		
	public static void main(String[] args) throws CloneNotSupportedException{
		Point p1 = new Point( 10,20,"P1");
		System.out.println("Point:" + p1);
		Point p2 = p1.clone();
		System.out.println("after clonning");
		p2.setLabel("P2");
		p2.setX(40);
		System.out.println("Point:" + p1);
		System.out.println("Point:" + p2);
	}	
}

class Point implements Cloneable{
	
	private int x;
	private int y;
	private StringBuffer label;
	
	public Point(int x, int y, String label) {
		super();
		this.x = x;
		this.y = y;
		this.label = new StringBuffer(label);
		
	}
	
	public Point clone() throws CloneNotSupportedException{
		Point c = (Point) super.clone();
		//!!! Трябва да се погрижим за всички обектни променливи
		c.label = new StringBuffer(this.label);
		return c;
	}
	public Point() {
		this(0,0,"");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getLabel() {
		return label.toString();
	}

	public void setLabel(String label) {
		this.label.delete(0, this.label.length());
		this.label.append(label);
		//private String label
		//this.label = label;
	}

	@Override
	public String toString() {
		return getLabel() + "->("+getX()+","+getY()+")";
	}
}