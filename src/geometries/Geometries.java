package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class Geometries is the basic class representing a list of geometries in a
 * Cartesian 3-Dimensional coordinate system, that implements Intersectable.
 * 
 * @author Ariels
 */
public class Geometries implements Intersectable {
	private List<Intersectable> geometries;

	// constructors

	/**
	 * constructor for geometries
	 */
	public Geometries() {
		geometries = new LinkedList<>();
	}

	/**
	 * constructor for geometries
	 * 
	 * @param geometries list of geometries
	 */
	public Geometries(Intersectable... geometries) {
		this.geometries = new LinkedList<>();
		Collections.addAll(this.geometries, geometries);
	}

	// functions

	/**
	 * add geometries to list
	 * 
	 * @param geometries list of geometries
	 */
	public void add(Intersectable... geometries) {
		Collections.addAll(this.geometries, geometries);
	}

	/**
	 * find intersections of ray with geometries
	 * 
	 * @param ray ray
	 * @return list of intersections
	 */
	@Override
	public List<Point> findIntersections(Ray ray) {
		List<Point> result = null;
		for (var shape : geometries) {
			List<Point> intersections = shape.findIntersections(ray);
			if (intersections != null) {
				if (result == null)
					result = new LinkedList<>();
				result.addAll(intersections);
			}
		}
		return result;
	}
}
