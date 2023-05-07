package geometries;

import java.util.List;

import primitives.*;

import static primitives.Util.*;

/**
 * Class Sphere is the basic class that extends RadialGeometry, representing a
 * 3-dimensional sphere in a Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public class Sphere extends RadialGeometry {

	private final Point center;

	// constructor
	/**
	 * constructor for a sphere
	 * 
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
	 * 
	 * @return center
	 */
	public Point getCenter() {
		return center;
	}

	/*
	 * get radius
	 * 
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

	/**
	 * find intersections of ray with sphere
	 * 
	 * @param ray ray
	 * @return list of intersections
	 */

	@Override
	public List<Point> findIntersections(Ray ray) {
		if (ray.getP0().equals(center))
			return List.of(ray.getPoint(radius));
		Vector u = center.subtract(ray.getP0());
		double tm = ray.getDir().dotProduct(u);
		double d2 = u.lengthSquared() - (tm * tm);
		double th2 = alignZero(radius2 - d2);
		if (th2 <= 0)
			return null;

		double th = Math.sqrt(th2);
		double t2 = alignZero(tm + th);
		if (t2 <= 0)
			return null;

		double t1 = alignZero(tm - th);
		return t1 > 0 ? List.of(ray.getPoint(t1), ray.getPoint(t2)) // both points
				: List.of(ray.getPoint(t2)); // 2nd point only
	}
}
