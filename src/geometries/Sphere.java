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
		double tm = alignZero(ray.getDir().dotProduct(u));
		if (tm < 0)
			return null;
		double d = alignZero(Math.sqrt(u.lengthSquared() - (tm * tm)));
		if (d >= radius)
			return null;
		double th = alignZero(Math.sqrt((radius * radius) - (d * d)));
		double t1 = alignZero(tm - th);
		double t2 = alignZero(tm + th);
		Point p2 = ray.getPoint(t2);
		if (t1 > 0)
			return List.of(ray.getPoint(t1), p2);
		return List.of(p2);
	}
}
