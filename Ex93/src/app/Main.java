package app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import containers.ArrayQueue;

public class Main {
		
	public static void main(String[] args) {
		Point [] points = new Point[5];
		Random rand = new Random(1);
		
		Arrays.parallelSetAll( points,
							   (i)->new Point(rand.nextInt(100), 
									          rand.nextInt(100),
									          "P"+i)
							  );
		
		System.out.println("Points:" + Arrays.toString(points));
		
		ArrayQueue<Point> aqp = new ArrayQueue<>(30);
		aqp.addAll( Arrays.asList(points));
		
		Iterator<Point> iter = aqp.iterator();
		while( iter.hasNext()) {
			System.out.print(" |" + iter.next());
		}
		System.out.println();
		try {
			
			try( ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("points.q")
					)){
				oos.writeObject(aqp);
				
			}
			
			System.out.println("From input stream:");
			
			try( ObjectInputStream ois  = new ObjectInputStream(
											 new FileInputStream("points.q")	
										 )){
				
				ArrayQueue<Point> aqp2 = (ArrayQueue<Point>)ois.readObject();
				for( final Point p: aqp2) {
					System.out.print("[" + p + "]");
				}
				System.out.println();
			}
			
		}
		catch(IOException|ClassNotFoundException e) {
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