package logic;

import java.util.function.Consumer;

import model.Point;

public interface Logic {
	
	public void run();
	public void moveDot(double virtualX, double virtualY, double virtualZ);
	public void forEachInWorld(Consumer<? super Point> action);
	
}
