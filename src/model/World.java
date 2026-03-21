package model;

import java.util.ArrayList;
import java.util.function.Consumer;

public class World {

	private ArrayList<Point> points;
	
	public World() {
		points = new ArrayList<>();
	}
	
	public void add(Point point) {
		points.add(point);
	}
	
	public Point get(int index) {
		return points.get(index);
	}
	
	public void move(int index, Point point) {
		Point before = points.get(index);
		Point after = before.add(point);
		points.set(index, after);
		System.out.println(after);
	}
	
	public void forEach(Consumer<? super Point> action) {
		points.forEach(action);
	}
	
}
