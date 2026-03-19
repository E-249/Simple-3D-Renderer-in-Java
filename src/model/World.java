package model;

import java.util.ArrayList;

import view.Drawable;
import view.Screen;

public class World implements Drawable {

	private ArrayList<Point> points;
	
	public World() {
		points = new ArrayList<>();
	}
	
	public void add(Point point) {
		points.add(point);
	}

	@Override
	public void drawAt(Screen s) {
		points.forEach(p -> p.drawAt(s));
	}
	
}
