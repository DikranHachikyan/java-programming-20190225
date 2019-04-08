package app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {
		
	public static void main(String[] args) throws CloneNotSupportedException {
		Point p1 = new Point(10,20,"P1");
		
		System.out.println("Point:" + p1);
		Point p2 = p1.clone();
		System.out.println("after clonning");
		p2.setLabel("P2");
		p2.setX(30);
		System.out.println("Point:" + p1);
		System.out.println("Point:" + p2);
		
		
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
		Point c = null;
		try {			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try( ObjectOutputStream oos = new ObjectOutputStream(baos)){
				oos.writeObject(this);
			}
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			try( ObjectInputStream ois = new ObjectInputStream(bais)){
				c = (Point)ois.readObject();
			}
		}
		catch(IOException | ClassNotFoundException e) {
			CloneNotSupportedException ex = new CloneNotSupportedException();
			ex.initCause(e);
			throw ex;
		}
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
	}

	@Override
	public String toString() {
		return getLabel() + "->("+getX()+","+getY()+")";
	}
}