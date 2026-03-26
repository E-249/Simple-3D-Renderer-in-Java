package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

public class Renderer {
	
	private final Dimension size;
	private final Screen screen;
	
	public Renderer(Dimension size) {
		this.size = size;
		screen = new Screen(size);
	}
	public Renderer(int width, int height) { this(new Dimension(width, height)); }
	public Renderer(int side) { this(new Dimension(side, side)); }
	
	public Image getImage() {
		return screen.getImage();
	}
	
	public void clear() {
		screen.clear();
	}
	
	public void virtualDrawAt(double x, double y) {
		virtualDrawAt(new VirtualU(x), new VirtualU(y)); }
	public void virtualDrawAt(VirtualU x, VirtualU y) {
		
		ScreenU screenX = x.intoX();
		ScreenU screenY = y.intoY();
		
		screenDrawAt(screenX, screenY);
	}
	
	public void virtualDrawLineAt(double x1, double y1, double x2, double y2) {
		virtualDrawLineAt(new VirtualU(x1), new VirtualU(y1), new VirtualU(x2), new VirtualU(y2)); }
	public void virtualDrawLineAt(VirtualU x1, VirtualU y1, VirtualU x2, VirtualU y2) {
		
		ScreenU screenX1 = x1.intoX();
		ScreenU screenY1 = y1.intoY();
		ScreenU screenX2 = x2.intoX();
		ScreenU screenY2 = y2.intoY();
		
		screenDrawLineAt(screenX1, screenY1, screenX2, screenY2);
	}
	
	public void virtualFillSquareAt(double x, double y, double s) {
		virtualFillSquareAt(new VirtualU(x), new VirtualU(y), new VirtualU(s)); }
	public void virtualFillSquareAt(VirtualU x, VirtualU y, VirtualU s) {
		
		ScreenU screenX = x.intoX();
		ScreenU screenY = y.intoY();
		ScreenU screenSW = s.intoW();
		@SuppressWarnings("unused") ScreenU screenSH = s.intoH();
		
		screenFillSquareAt(screenX, screenY, screenSW);
	}
	
	public void virtualFillCircleAt(double x, double y, double r) {
		virtualFillCircleAt(new VirtualU(x), new VirtualU(y), new VirtualU(r)); }
	public void virtualFillCircleAt(VirtualU x, VirtualU y, VirtualU r) {
		
		ScreenU screenX = x.intoX();
		ScreenU screenY = y.intoY();
		ScreenU screenRW = r.intoW();
		@SuppressWarnings("unused") ScreenU screenRH = r.intoH();
		
		screenFillCircleAt(screenX, screenY, screenRW);
	}
	
	public void screenDrawAt(int x, int y) {
		screenDrawAt(new ScreenU(x), new ScreenU(y)); }
	public void screenDrawAt(ScreenU x, ScreenU y) {
		
		screen.setRGB(
				x.value(),
				y.value(),
				Color.WHITE.getRGB());
	}
	
	public void screenDrawLineAt(int x1, int y1, int x2, int y2) {
		screenDrawLineAt(new ScreenU(x1), new ScreenU(y1), new ScreenU(x2), new ScreenU(y2)); }
	public void screenDrawLineAt(ScreenU x1, ScreenU y1, ScreenU x2, ScreenU y2) {
		
		screen.getGraphics().setColor(Color.WHITE);
		screen.getGraphics().drawLine(x1.value, y1.value, x2.value, y2.value);
	}
	
	public void screenFillSquareAt(int x, int y, int s) {
		screenFillSquareAt(new ScreenU(x), new ScreenU(y), new ScreenU(s)); }
	public void screenFillSquareAt(ScreenU x, ScreenU y, ScreenU s) {
		
		screen.getGraphics().fillRect(
				x.value() - s.value() / 2,
				y.value() - s.value() / 2,
				s.value(),
				s.value());
	}
	
	public void screenFillCircleAt(int x, int y, int r) {
		screenFillCircleAt(new ScreenU(x), new ScreenU(y), new ScreenU(r)); }
	public void screenFillCircleAt(ScreenU x, ScreenU y, ScreenU r) {
		
		screen.getGraphics().fillOval(
				x.value() - r.value() / 2,
				y.value() - r.value() / 2,
				r.value(),
				r.value());
	}
	
	
	
	
	
	
	
	public record ScreenU(int value) {}
	
	public class VirtualU {
		
		public final double value;
		public VirtualU(double value) { this.value = value; }
		
		public ScreenU intoX() {
			return new ScreenU( (int) ((value + 1) / 2 * size.width) );
		}
		
		public ScreenU intoY() {
			return new ScreenU( (int) ((1 - (value + 1) / 2) * size.height) );
		}
		
		public ScreenU intoW() {
			return new ScreenU( (int) (value / 2 * size.width) );
		}
		
		public ScreenU intoH() {
			return new ScreenU( (int) (value / 2 * size.height) );
		}
	}

}
