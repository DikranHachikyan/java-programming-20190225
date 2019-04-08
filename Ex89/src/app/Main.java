package app;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;



public class Main {
		
	public static void main(String[] args){
		Point [] points = new Point[5];
		Random rand = new Random(0);
		
		Arrays.parallelSetAll(points, (i)->new Point(rand.nextInt(100),rand.nextInt(100)));
		System.out.println("Points:" + Arrays.toString(points));
		try {
			try( DataOutputStream dos = new DataOutputStream( 
												new FileOutputStream("points.bin") )) {
				for( final Point p: points) {
					dos.writeInt(p.getX());
					dos.writeInt(p.getY());
				}
			}// data output stream
			
			try( RandomAccessFile raf = new RandomAccessFile("points.bin","r")){
				int size = (int)(raf.length() / Point.POINT_SIZE);
				Point [] newPoints = new Point[size];
				
				// size = 5
				for( int i = 0 ; i < size ; i++) {
					newPoints[i] = new Point();
					raf.seek( (size - i - 1) * Point.POINT_SIZE);
					newPoints[i].setX( raf.readInt());
					newPoints[i].setY( raf.readInt());
				}
				
				System.out.println("New Points:" + Arrays.toString(newPoints));
			}//random access file
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}	
}

class Point {
	public static final int POINT_SIZE = Integer.BYTES * 2;
	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0,0);
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
	
	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}
}