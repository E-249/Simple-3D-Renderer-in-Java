package logic;

import java.util.function.Consumer;

import model.Point;
import model.World;

public class LogicImpl implements Logic {
	
	private final World world;
	
	public LogicImpl() {
		this.world = new World();
		
		world.add(new Point(0.5, 0.5, 1));
	}
	
	@Override
	public void run() {
		
	}
	
	
	@Override
	public void moveDot(double virtualX, double virtualY, double virtualZ) {
		world.move(0, new Point(virtualX, virtualY, virtualZ));
	}
	
	@Override
	public void forEachInWorld(Consumer<? super Point> action) {
		world.forEach(action);
	}

}
