package geometries;

import java.util.List;

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
	/**
	 * constructor for a sphere
	 * @param r double
	 * @param c point
	 */
	public Sphere(double r, Point c) {
		super(r);
		center = c;
	}

	// getters
	/*
	 * get center
	 * @return center
	 */
	public Point getCenter() {
		return center;
	}

	/*
	 * get radius
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	// functions
	@Override
	public Vector getNormal(Point p) {
		Vector v = p.subtract(center);
		return v.normalize();
	}
	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
