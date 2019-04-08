package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {
		
	public static void main(String[] args) {
		Point p1 = new Point(10,20,"P1");
		
		System.out.println("Point:" + p1);
		try {
			
			try( ObjectOutputStream oos = new ObjectOutputStream(
												new FileOutputStream("point.obj")
											)){
				oos.writeObject(p1);
				
			}
			
			try( ObjectInputStream ois = new ObjectInputStream( 
												new FileInputStream("point.obj")
											)){
				Point p2 = (Point)ois.readObject();
				p2.setLabel("LP2");
				p2.setX(40);
				System.out.println("Point:" + p1);
				System.out.println("Point:" + p2);
				
			}
		}
		catch(IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}	
}

class Point implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
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