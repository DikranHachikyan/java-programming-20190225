package draw;

public interface Shape {
	//public static final
	int MIN_X = 0;
	int MIN_Y = 0;
	
	public void moveTo(int dx, int dy);//метод без тяло (абстрактни)
	//public void moveTo2(int dx, int dy){}//метод с празно тяло
	public void redraw();
	
	public void scale(int dw, int dh);
}
