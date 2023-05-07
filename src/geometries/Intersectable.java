package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;

/**
 * Intersectable is an interface for all geometries that are able to intersect
 * 
 * @author Ariel {David and Falik}
 */
public interface Intersectable {
	/**
	 * find intersections with a ray
	 * 
	 * @param ray ray to intersect with
	 * @return list of intersections
	 */
	List<Point> findIntersections(Ray ray);
}
