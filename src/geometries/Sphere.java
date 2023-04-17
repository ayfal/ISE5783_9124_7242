package geometries;

import primitives.*;

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
		Vector v1 = p.subtract(center);
		return v1.normalize();
	}
}
