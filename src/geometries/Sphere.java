package geometries;

import primitives.*;

/**
 * Class Sphere is the basic class that extends RadialGeometry, representing a 3-dimensional sphere in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public class Sphere extends RadialGeometry {

	private final Point center;

	// constructor
	public Sphere(double r, Point c) {
		super(r);
		center = c;
	}

	// getters
	public Point getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	// functions
	@Override
	public Vector getNormal(Point p) {
		Vector v = p.subtract(center);
		return v.normalize();
	}
}
