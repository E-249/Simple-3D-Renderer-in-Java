package model;

public class Cube {

	private Point centre;
	private double width, height, depth;
	
	public Cube(Point centre, double width, double height, double depth) {
		this.centre = centre;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public void move(Point offset) {
		centre = centre.add(offset);
	}
	
	private double near() { return -depth / 2; }
	private double far() { return +depth / 2; }
	private double lower() { return -height / 2; }
	private double upper() { return +height / 2; }
	private double left() { return -width / 2; }
	private double right() { return +width / 2; }
	
	public Point getNearLowerLeft()	{ return centre.add(new Point(left(), lower(), near())); }
	public Point getFarLowerLeft() { return centre.add(new Point(left(), lower(), far())); }
	public Point getNearUpperLeft() { return centre.add(new Point(left(), upper(), near())); }
	public Point getFarUpperLeft() { return centre.add(new Point(left(), upper(), far())); }
	public Point getNearLowerRight() { return centre.add(new Point(right(), lower(), near())); }
	public Point getFarLowerRight() { return centre.add(new Point(right(), lower(), far())); }
	public Point getNearUpperRight() { return centre.add(new Point(right(), upper(), near())); }	
	public Point getFarUpperRight() { return centre.add(new Point(right(), upper(), far())); }
	
	@Override
	public String toString() {
		return centre.toString();
	}
	
}
