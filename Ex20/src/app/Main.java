package app;

import draw.Point;

public class Main {

	public static void main(String[] args) {
		//Point - клас (типа)
		//p     - променлива, която сочи към обект от тип Point (обект)
		Point p = new Point();
		
		//1. Лоша практика
		//p.x = 100000;
		//p.y = 600000;

		//System.out.println("Point: (" + p.x + ", " + p.y + ")");
		
		//2. Добра практика
		p.setX(120);
		p.setY(230);
		
		System.out.println("Point (" + p.getX()+ ", " + p.getY() + ") is visible:" + p.isVisible());
	}

}
 