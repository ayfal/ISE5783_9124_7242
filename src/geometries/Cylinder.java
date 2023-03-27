package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

public class Cylinder extends Tube {

	private final double height;

	// constructor
	public Cylinder(double h, double radius, Ray axis) {
		super(radius, axis);
		this.height = h;
	}

	// getter
	public double getHeight() {
		return height;
	}

	// functions
	@Override
	public Vector getNormal(Point p) {
		return null;
	}

}
