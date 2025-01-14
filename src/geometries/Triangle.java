package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

/**
 * Class Triangle is the basic class that extends polygon, representing a
 * two-dimensional triangle in a Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public class Triangle extends Polygon {

	// constructor
	/**
	 * constructor for a triangle
	 * 
	 * @param p1 point
	 * @param p2 point
	 * @param p3 point
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		super(p1, p2, p3);
	}

	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
		List<GeoPoint> planeIntersections = plane.findGeoIntersections(ray);
		if (planeIntersections == null)
			return null;

		Point p0 = ray.getP0();
		Vector v = ray.getDir();
		Vector v1 = vertices.get(0).subtract(p0);
		Vector v2 = vertices.get(1).subtract(p0);
		Vector n1 = v1.crossProduct(v2);
		double s1 = alignZero(v.dotProduct(n1));
		if (s1 == 0)
			return null;

		Vector v3 = vertices.get(2).subtract(p0);
		Vector n2 = v2.crossProduct(v3);
		double s2 = alignZero(v.dotProduct(n2));
		if (s1 * s2 <= 0)
			return null;

		Vector n3 = v3.crossProduct(v1);
		double s3 = alignZero(v.dotProduct(n3));
		if (s1 * s3 <= 0)
			return null;

		planeIntersections.get(0).geometry = this;
		return planeIntersections;
	}
}
