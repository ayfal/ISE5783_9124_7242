package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Class Plane is the basic class representing a two-dimensional plane in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */

public class Plane {

	private final Point p0;

	private final Vector normal;

	// constructors

	public Plane(Point p0, Point p1, Point p2) {
		this.p0 = p0;
		Vector v1 = p1.subtract(p0);
		Vector v2 = p2.subtract(p0);
		Vector n = v1.crossProduct(v2);
		// if the to vectors have the same direction.
		if (n.length() == 0)
			throw new IllegalArgumentException("The points are on the same line");
		this.normal = n.normalize();
	}

	public Plane(Point p, Vector n) {
       
		this.p0 = p;
		this.normal = n.normalize();
	}

	// getters

	public Point getP0() {
		return p0;
	}

	public Vector getNormal() {
		return normal;
	}

	public Vector gerNormal(Point p) {
		return normal;
	}

}
