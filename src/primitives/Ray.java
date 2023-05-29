package primitives;

import static primitives.Util.*;
import geometries.Intersectable.GeoPoint;

import java.util.List;

/**
 * Class Ray is the basic class representing a point and a direction in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David and Moshe
 */

public class Ray {

	private final Point p0;

	private final Vector dir;

	// constructor
	/**
	 * constructor for a ray
	 * 
	 * @param p point
	 * @param d vector
	 */
	public Ray(Point p, Vector d) {
		this.p0 = p;
		this.dir = d.normalize();
	}

	// getters
	/**
	 * get reference point of ray
	 * 
	 * @return reference point
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * get direction of ray
	 * 
	 * @return direction vector
	 */
	public Vector getDir() {
		return dir;
	}

	// functions
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return (obj instanceof Ray other) && (this.p0.equals(other.p0) && this.dir.equals(other.dir));
	}

	@Override
	public String toString() {
		return "Ray { p0 =  " + p0 + ", dir = " + dir + " }\n";
	}

	/**
	 * get point on ray at distance t1 from p0
	 * 
	 * @param t1 distance
	 * @return point on ray
	 */
	public Point getPoint(double t1) {
		return isZero(t1) ? p0 : p0.add(dir.scale(t1));
	}

	/**
	 * find the closest point to p0 from a list of points
	 * 
	 * @param points list of points
	 * @return closest point
	 */
	public Point findClosestPoint(List<Point> points) {
		return points == null || points.isEmpty() ? null :
		 findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
	}

	/**
	 * find the closest GeoPoint to p0 from a list of GeoPoints
	 * 
	 * @param points list of GeoPoints
	 * @return closest GeoPoint
	 */
	public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
		GeoPoint closestPoint = null;
		double closestDistance = Double.POSITIVE_INFINITY;
		for (GeoPoint point : points) {
			double distance = point.point.distance(p0);
			if (distance < closestDistance) {
				closestDistance = distance;
				closestPoint = point;
			}
		}
		return closestPoint;
	}
}
