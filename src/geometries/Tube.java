package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;

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
		Vector PP0 = p.subtract(axis.getP0());
		double t = axis.getDir().dotProduct(PP0);

		Point o = axis.getP0().add(axis.getDir().scale(t));// do i use scale?

		return p.subtract(o);/////////////
	}

}
