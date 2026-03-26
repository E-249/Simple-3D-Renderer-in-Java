package model;

import java.util.ArrayList;
import java.util.function.Consumer;

public class World {

	private ArrayList<Point> points;
	private ArrayList<Cube> cubes;
	
	public World() {
		points = new ArrayList<>();
		cubes = new ArrayList<>();
	}
	
	/* Point */
	
	public void add(Point point) {
		points.add(point);
	}
	
	public Point getPoint(int index) {
		return points.get(index);
	}
	
	public void movePoint(int index, Point offset) {
		Point before = points.get(index);
		Point after = before.add(offset);
		points.set(index, after);
		System.out.println(after);
	}
	
	public void forEachPoint(Consumer<? super Point> action) {
		points.forEach(action);
	}

	/* Cube */
	
	public void add(Cube cube) {
		cubes.add(cube);
	}
	
	public Cube getCube(int index) {
		return cubes.get(index);
	}
	
	public void moveCube(int index, Point offset) {
		Cube cube = cubes.get(index);
		cube.move(offset);
		System.out.println(cube);
	}
	
	public void forEachCube(Consumer<? super Cube> action) {
		cubes.forEach(action);
	}
	
}
