package logic;

import java.util.function.Consumer;

import model.Cube;
import model.Point;

public interface Logic {
	
	public void run();
	public void moveDot(double virtualX, double virtualY, double virtualZ);
	public void forEachInWorld(Consumer<? super Point> action);
	
	public void moveCube(double virtualX, double virtualY, double virtualZ);
	public void forEachCubeInWorld(Consumer<? super Cube> action);
	
}
