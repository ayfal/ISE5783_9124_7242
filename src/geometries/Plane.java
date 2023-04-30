package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Class Plane is the basic class representing a two-dimensional plane in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */

public class Plane implements Geometry {

	private final Point p0;

	private final Vector normal;

	// constructors
	/**
	 * constructor for a plane
	 * sets the normal to be the cross product of the vectors from p0 to p1 and p2
	 * @param p0 point
	 * @param p1 point
	 * @param p2 point
	 */
	public Plane(Point p0, Point p1, Point p2) {
		this.p0 = p0;
		Vector v1 = p1.subtract(p0);
		Vector v2 = p2.subtract(p0);
		Vector n = v1.crossProduct(v2);
		this.normal = n.normalize();
	}

	/**
	 * constructor for a plane
	 * @param p point
	 * @param n vector
	 */
	public Plane(Point p, Vector n) {
		this.p0 = p;
		this.normal = n.normalize();
	}

	// getters
	/**
	 * get p0
	 * @return p0
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * get normal
	 * @return normal
	 */
	public Vector getNormal() {
		return normal;
	}

	@Override
	public Vector getNormal(Point p) {
		return normal;
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
