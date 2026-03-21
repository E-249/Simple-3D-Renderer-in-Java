package logic;

import java.util.function.Consumer;

import model.Point;
import model.World;

public class Logic {
	
	private final World world;
	
	public Logic() {
		this.world = new World();
		
		world.add(new Point(0.5, 0.5, 1));
	}
	
	public void run() {
		
	}
	
	public void moveDot(double virtualX, double virtualY, double virtualZ) {
		world.move(0, new Point(virtualX, virtualY, virtualZ));
	}
	
	public void forEachInWorld(Consumer<? super Point> action) {
		world.forEach(action);
	}

}
