package draw;

public class Point {
	//1. данни на класа
	//public int x = 10;
	//public int y = 20;
	
	private int x = 10;
	private int y = 20;
	private boolean visible = true;
	
	//2, методи на класа
	
	public void setX(int a) {
		//if( x < 0 || x > 9999999 ) ....
		x = a;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY( int a) {
		y = a;
	}
	
	public int getY() {
		return y;
	}
	
	private void setVisible( boolean v) {
		visible = v;
	}
	
	public boolean isVisible() {
		return visible;
	}
}
