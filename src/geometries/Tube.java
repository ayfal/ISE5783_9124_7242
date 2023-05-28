package geometries;

import primitives.Point;

import primitives.Vector;
import primitives.Ray;

import java.util.List;

/**
 * Class Tube is the basic class that extends RadialGeometry, representing a
 * 3-dimensional Tube(endless cylinder) in a Cartesian 3-Dimensional coordinate
 * system.
 * 
 * @author Ariel David
 */
public class Tube extends RadialGeometry {

	/**
	 * axis ray of the tube
	 */
	protected final Ray axis;

	// constructor
	/**
	 * constructor for a tube
	 * 
	 * @param radius double
	 * @param ax     ray
	 */
	public Tube(double radius, Ray ax) {
		super(radius);
		this.axis = ax;
	}

	// getters
	/**
	 * get axis
	 * 
	 * @return axis
	 */
	public Ray getAxis() {
		return axis;
	}

	/**
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
		double t = axis.getDir().dotProduct(p.subtract(axis.getP0()));
		return p.subtract(axis.getPoint(t)).normalize();
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
