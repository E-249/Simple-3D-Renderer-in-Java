package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Screen {
	
	public final Dimension size;
	public final BufferedImage image;
	
	/**
	 * @param size of the window (owned value)
	 */
	public Screen(Dimension size) {
		this.size = size;
		image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
	}
	public Screen(int width, int height) { this(new Dimension(width, height)); }
	public Screen(int side) { this(new Dimension(side, side)); }
	
	
	public void clear() {
		image.getGraphics().clearRect(0, 0, size.width, size.height);
	}
	
	
	
	public int getScreenX(double virtualX) {
		return (int) ((virtualX + 1) / 2 * size.width);
	}
	
	public int getScreenY(double virtualY) {
		return (int) ((1 - (virtualY + 1) / 2) * size.height);
	}
	
	public int getScreenW(double virtualW) {
		return (int) (virtualW / 2 * size.width);
	}
	
	public int getScreenH(double virtualH) {
		return (int) (virtualH / 2 * size.height);
	}
	
	
	
	public void virtualDrawAt(double virtualX, double virtualY) {
		
		int screenX = getScreenX(virtualX);
		int screenY = getScreenY(virtualY);
		
		screenDrawAt(screenX, screenY);
	}
	
	public void virtualFillSquareAt(double virtualX, double virtualY, double virtualS) {
		
		int screenX = getScreenX(virtualX);
		int screenY = getScreenY(virtualY);
		int screenSW = getScreenW(virtualS);
		@SuppressWarnings("unused") int screenSH = getScreenH(virtualS);
		
		screenFillSquareAt(screenX, screenY, screenSW);
	}
	
	public void virtualFillCircleAt(double virtualX, double virtualY, double virtualR) {
		
		int screenX = getScreenX(virtualX);
		int screenY = getScreenY(virtualY);
		int screenRW = getScreenW(virtualR);
		@SuppressWarnings("unused") int screenRH = getScreenH(virtualR);
		
		screenFillCircleAt(screenX, screenY, screenRW);
	}
	
	
	public void screenDrawAt(int screenX, int screenY) {
		
		image.setRGB(
				screenX,
				screenY,
				Color.WHITE.getRGB());
	}
	
	public void screenFillSquareAt(int screenX, int screenY, int screenS) {
		
		image.getGraphics().fillRect(
				screenX - screenS / 2,
				screenY - screenS / 2,
				screenS,
				screenS);
	}
	
	public void screenFillCircleAt(int screenX, int screenY, int screenR) {
		
		image.getGraphics().fillOval(
				screenX - screenR / 2,
				screenY - screenR / 2,
				screenR,
				screenR);
	}

}
