package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Class Plane is the basic class representing a … of Euclidean geometry in
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David and Moshe
 */
 
public class Plane {

	private final Point p0;

	private final Vector normal;

	// constructors

	public Plane(Point p1, Point p2, Point p3) {
		this.p0 = p1;
		this.normal = null;
	}

	public Plane(Point p, Vector n) {
		n.normalize();

		this.p0 = p;
		this.normal = n;
	}

	// getters

	public Point getP0() {
		return p0;
	}

	public Vector getNormal() {
		return normal;
	}

	public Vector gerNormal(Point p) {
		return null;
	}

}
