package draw;

public interface Shape {
	
	public void moveTo(int dx, int dy);//метод без тяло (абстрактни)
	//public void moveTo2(int dx, int dy){}//метод с празно тяло
	public void redraw();
	
	public void scale(int dw, int dh);
}
