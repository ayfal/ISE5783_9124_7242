package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;
import static primitives.Util.*;

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

		if (isZero(t))
			return p.subtract(p0).normalize();

		Point o = p0.add(dir.scale(t));
		return p.subtract(o).normalize();
	}

}
