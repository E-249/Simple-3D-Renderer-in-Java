package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Screen {
	
	private final BufferedImage image;
	
	/**
	 * @param size of the window (owned value)
	 */
	public Screen(Dimension size) {
		image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
	}
	public Screen(int width, int height) { this(new Dimension(width, height)); }
	public Screen(int side) { this(new Dimension(side, side)); }
	
	
	public void clear() {
		image.getGraphics().clearRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	public void setRGB(int x, int y, int rgb) {
        image.setRGB(x, y, rgb);
    }
	
	public Graphics getGraphics() {
		return image.getGraphics();
	}
	
	public Image getImage() {
		return image;
	}

}
