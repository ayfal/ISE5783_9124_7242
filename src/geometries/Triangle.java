package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;

/**
 * Class Triangle is the basic class that extends polygon, representing a two-dimensional triangle in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public class Triangle extends Polygon {

	// constructor
	/**
	 * constructor for a triangle
	 * @param p1 point
	 * @param p2 point
	 * @param p3 point
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		super(p1, p2, p3);
	}
	
	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
  