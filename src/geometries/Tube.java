package geometries;

import primitives.Point;

import primitives.Vector;
import primitives.Ray;
import static primitives.Util.*;

import java.util.List;

/**
 * Class Tube is the basic class that extends RadialGeometry, representing a 3-dimensional Tube(endless cylinder) in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public class Tube extends RadialGeometry {

	protected final Ray axis;

	// constructor
	/**
	 * constructor for a tube
	 * @param radius double
	 * @param ax ray
	 */
	public Tube(double radius, Ray ax) {
		super(radius);
		this.axis = ax;
	}

	// getters
	/**
	 * get axis
	 * @return axis
	 */
	public Ray getAxis() {
		return axis;
	}

	/**
	 * get radius
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	// functions
	@Override
	public Vector getNormal(Point p) {
		Point p0 = axis.getP0();
		Vector dir = axis.getDir();
		double t = dir.dotProduct(p.subtract(p0));

		Point o = isZero(t) ? p0 : p0.add(dir.scale(t));
		return p.subtract(o).normalize();
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
