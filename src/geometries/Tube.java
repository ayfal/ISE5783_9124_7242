package geometries;

import primitives.Point;

import primitives.Vector;
import primitives.Ray;
import static primitives.Util.*;

/**
 * Class Tube is the basic class that extends RadialGeometry, representing a 3-dimensional Tube(endless cylinder) in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public class Tube extends RadialGeometry {

	protected final Ray axis;

	// constructor
	public Tube(double radius, Ray ax) {
		super(radius);
		this.axis = ax;
	}

	// getters
	public Ray getAxis() {
		return axis;
	}

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

}
