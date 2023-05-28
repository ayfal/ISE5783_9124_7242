package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;

/**
 * Intersectable is an abstarct class for all geometries that are able to intersect
 * 
 * @author Ariel {David and Falik}
 */
public abstract class Intersectable {
	/**
	 * find intersections with a ray
	 * 
	 * @param ray ray to intersect with
	 * @return list of intersections
	 */
	public List<Point> findIntersections(Ray ray);

	/**
	 * GeoPoint is a static inner class that represents a point on a geometry body
	 */
	public static class GeoPoint { 
		/**
		 * geometry body
		 */
		public Geometry geometry; 

		/**
		 * point on the geometry body
		 */
		public Point point; 

		// ***************** Constructors ********************** //

		/**
		 * constructs a GeoPoint with a given geometry body and a point on it
		 * 
		 * @param g geometry body
		 * @param p point on the geometry body
		 */
		public GeoPoint(Geometry g, Point p) {
			geometry = g;
			point = p;
		}

		// ***************** Functions ********************** //
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			return (obj instanceof GeoPoint other) && geometry.equals(other.geometry) && point.equals(other.point);					
		}

		
		@Override
		public String toString() {
			return "GeoPoint [geometry=" + geometry + ", point=" + point + "]";
		}
	}
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		return findGeoIntersectionsHelper(ray);
	}

	protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);
}
