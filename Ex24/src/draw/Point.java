package draw;

public class Point {
	//1. данни на класа

	private int x = 10;
	private int y = 20;
	private boolean visible = true;
	
	//2. методи на класа
	//2.1 Конструктор
	//празен конструктор
	//public Point() {}
	
	public Point(int x , int y){
		//Инициализация на данните на класа
		setX(x);
		setY(y);
		if( getX() < 0 || getY()< 0 ) {
			setVisible(false);
		}
		else {
			setVisible(true);
		}
		System.out.println("Ctor Point 1");
	}
	
	public Point() {
		this(0, 0);
		System.out.println("Ctor Point 2");
	}
	
	public void setX(int x) {
		setVisible( !(x < 0 ) );
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY( int a) {
		setVisible( !(a < 0 ) );
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
	
	public void draw() {
		String type = ( isVisible() )? "visible":"hidden";
		System.out.println("Draw " + type + " point (" + getX() + ", " + getY() + ")");
	}
}
