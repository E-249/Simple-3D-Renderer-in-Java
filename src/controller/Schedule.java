package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.World;
import view.Mouse;
import view.Screen;

public class Schedule extends TimerTask {
	
	private static final long DEFAULT_PERIOD = 7;
	
	private final Runnable update;
	private final Screen screen;
	private final Mouse mouse;
	private final World world;

	private final Timer timer;
	private final long period;
	
	
	public Schedule(long period, Runnable update, Screen screen, Mouse mouse, World world) {
		this.update = update;
		this.screen = screen;
		this.mouse = mouse;
		this.world = world;
		
		this.timer = new Timer();
		this.period = period;
	}
	
	public Schedule(Runnable update, Screen screen, Mouse mouse, World world) {
		this(DEFAULT_PERIOD, update, screen, mouse, world);
	}
	
	public void start() {
		timer.schedule(this, 0, period);
	}
	
	@Override
	public void run() {
		screen.clear();
		try {
			
			screen.screenFillSquareAt(mouse.getX(), mouse.getY(), screen.getScreenW(0.25));
			world.drawAt(screen);
			
		} catch (Exception e) {}
		update.run();
	}
	
}
