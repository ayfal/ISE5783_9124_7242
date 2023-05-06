package geometries;

import java.util.List;

// import primitives.Point;
// import primitives.Ray;
// import primitives.Vector;
// import primitives.Util;
import primitives.*;
import static primitives.Util.*;

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
	 * 
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
	 * 
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
	 * 
	 * @return p0
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * get normal
	 * 
	 * @return normal
	 */
	public Vector getNormal() {
		return normal;
	}

	/**
	 * get normal
	 * @param p point
	 * @return normal
	 */
	@Override
	public Vector getNormal(Point p) {
		return normal;
	}

	/**
	 * find intersections of ray with plane
	 * @param ray ray
	 * @return list of intersections
	 */
	@Override
	public List<Point> findIntersections(Ray ray) {
		double nv = alignZero(normal.dotProduct(ray.getDir()));
		if (isZero(nv))
			return null;
		if (p0.equals(ray.getP0()))
			return null;
		double nQMinusP0 = alignZero(normal.dotProduct(p0.subtract(ray.getP0())));
		double t = alignZero(nQMinusP0 / nv);
		if (t > 0)
			return List.of(ray.getPoint(t));
		return null;
	}
	
}
