package controller;

import java.awt.EventQueue;

import model.Point;
import model.World;
import view.Frame;
import view.Mouse;
import view.Screen;

public class Launch {
	
	private Frame frame;
	private Screen screen;
	private Mouse mouse;
	private World world;
	private Schedule schedule;
	
	public Launch() {
		
		screen = new Screen(800);
		mouse = new Mouse();
		frame = new Frame(screen, mouse);
		world = new World();
		schedule = new Schedule(frame::repaint, screen, mouse, world);
		
		world.add(new Point(0.5, 0.5, 1));
		
		frame.setVisible(true);
		schedule.start();
		
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					new Launch();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
