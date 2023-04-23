package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

/**
 * Class Cylinder is a class that extends Tube, representing a 3-dimensional cylinder(finite Tube) in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
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
