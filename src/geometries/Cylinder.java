package geometries;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;
import static primitives.Util.*;

import java.util.List;

/**
 * Class Cylinder is a class that extends Tube, representing a 3-dimensional
 * cylinder which is a tube with a height, (The tube is defined by its radius,
 * its axis ray and its height) in a Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public class Cylinder extends Tube {

	private final double height;

	// constructor
	/**
	 * constructor for a cylinder
	 * 
	 * @param h      double
	 * @param radius double
	 * @param axis   ray
	 */
	public Cylinder(double h, double radius, Ray axis) {
		super(radius, axis);
		this.height = h;
	}

	// getter
	/**
	 * get height
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	// functions
	@Override
	public Vector getNormal(Point p) {
		Vector dir = axis.getDir();
		Point bottomCenter = axis.getP0();
		Point topCenter = bottomCenter.add(dir.scale(height));
		Vector upVector = dir;
		Vector downVector = dir.scale(-1);

		if (p.equals(bottomCenter))
			return downVector;
		if (p.equals(topCenter))
			return upVector;

		double t = dir.dotProduct(p.subtract(bottomCenter));
		if (isZero(t))
			return downVector;
		if (isZero(t - height))
			return upVector;

		Point o = bottomCenter.add(dir.scale(t));
		return p.subtract(o).normalize();
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
}
