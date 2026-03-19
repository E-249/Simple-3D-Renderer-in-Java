package model;

import view.Drawable;
import view.Screen;

public record Point(double x, double y, double z) implements Drawable {

	@Override
	public void drawAt(Screen screen) {
		screen.virtualFillSquareAt(x / z, y / z, 0.2);
	}
	
}
