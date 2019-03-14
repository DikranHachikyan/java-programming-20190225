package draw;

public class Rectangle extends Point {
	//1. данни на класа
	private int width;
	private int height;
	
	//2. методи класа
	public Rectangle(int x, int y, int width, int height) {
		//извикване на конструктора на прекия родител
		super(x,y);
		//инициализация на собствените данни
		setWidth(width);
		setHeight(height);
		
		System.out.println("Ctor Rectangle 1");
	}
	
	public Rectangle() {
		this(0, 0, 0, 0);
		System.out.println("Ctor Rectangle 2");
	}
	
	//function overriding
	@Override
	public void draw() {
		//изпълняваме онова, което е в родителя
		super.draw();
		//+ специфичното за наследника
		System.out.println("Rectange [" 
		                                + getWidth()  +
		                   ", "         + getHeight() + 
		                   "]");
	}
	
	public void fillWithColor( int color) {
		System.out.println("Fill with color:" + color);
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth( int width) {
		this.width = width;
	}

	@Override
	public void moveTo(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(int dw, int dh) {
		// TODO Auto-generated method stub
		
	}
}
