package logic;

import java.util.Timer;
import java.util.TimerTask;

import view.Frame;

public class Schedule {
	
	private static final long DEFAULT_PERIOD = 7;

	private final Logic logic;
	private final Frame frame;

	private final Timer timer;
	private final long period;
	
	
	public Schedule(long period, Logic logic, Frame frame) {
		this.logic = logic;
		this.frame = frame;
		
		this.period = period;
		this.timer = new Timer();
	}
	
	public Schedule(Logic logic, Frame frame) {
		this(DEFAULT_PERIOD, logic, frame);
	}
	
	public void start() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				try {
					logic.run();
					frame.update();
				} catch (Exception e) {}
				
			}
		}, 0, period);
	}
	
}
