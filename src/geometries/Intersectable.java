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
	 * find intersections
	 * 
	 * @param ray ray
	 * @return list of intersections
	 */
	List<Point> findIntersections(Ray ray);
}
