package logic;

import java.awt.EventQueue;

import view.Frame;

public class Launch {
	
	private Frame frame;
	private Logic logic;
	private Schedule schedule;
	
	public Launch() {
		
		logic = new LogicImpl();
		frame = new Frame(800, logic);
		schedule = new Schedule(logic, frame);
		
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
