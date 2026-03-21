package model;

public record Point(double x, double y, double z) {
	
	public Point add(Point that) {
		double x = this.x + that.x;
		double y = this.y + that.y;
		double z = this.z + that.z;
		return new Point(x, y, z);
	}
	
}
