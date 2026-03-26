package logic;

import java.util.function.Consumer;

import model.Cube;
import model.Point;
import model.World;

public class LogicImpl implements Logic {
	
	private final World world;
	
	public LogicImpl() {
		this.world = new World();
		
		//world.add(new Point(0.5, 0.5, 1));
		
		
		Cube armario = new Cube(new Point(0.45, -0.1, 1), .4, .7, .4);
		Cube montaña = new Cube(new Point(0.2, -2.0, 4.0), 4.2, 2.7, 2.2);
		world.add(armario);
		world.add(montaña);
		
//		world.add(cube.getFarLowerLeft());
//		world.add(cube.getFarLowerRight());
//		world.add(cube.getFarUpperLeft());
//		world.add(cube.getFarUpperRight());
//		world.add(cube.getNearLowerLeft());
//		world.add(cube.getNearLowerRight());
//		world.add(cube.getNearUpperLeft());
//		world.add(cube.getNearUpperRight());
		
	}
	
	@Override
	public void run() {
		
	}
	
	
	@Override
	public void moveDot(double virtualX, double virtualY, double virtualZ) {
		world.movePoint(0, new Point(virtualX, virtualY, virtualZ));
	}
	
	@Override
	public void forEachInWorld(Consumer<? super Point> action) {
		world.forEachPoint(action);
	}
	
	@Override
	public void moveCube(double virtualX, double virtualY, double virtualZ) {
		world.moveCube(0, new Point(virtualX, virtualY, virtualZ));
	}
	
	@Override
	public void forEachCubeInWorld(Consumer<? super Cube> action) {
		world.forEachCube(action);
	}

}
