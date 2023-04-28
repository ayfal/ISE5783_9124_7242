package primitives;

/**
 * Class Point is the basic class representing a coordinate in a 3-Dimensional space.
 * 
 * @author Ariel David and Moshe Weisfish
 */
public class Point {

	final Double3 point;

	// constructors
	public Point(Double3 d) {
		this(d.d1, d.d2, d.d3);
	}

	public Point(double d1, double d2, double d3) {
		point = new Double3(d1, d2, d3);
	}

	// functions

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return (obj instanceof Point other) && this.point.equals(other.point);
	}

	
	public double distanceSquared(Point other) {
		double x = this.point.d1 - other.point.d1;
		double y = this.point.d2 - other.point.d2;
		double z = this.point.d3 - other.point.d3;

		return x * x + y * y + z * z;
	}

	/**
	 * returns the distance between two points.
	 * @author Ariel David
	 */
	public double distance(Point other) {
		return Math.sqrt(this.distanceSquared(other));
	}

	/**
	 * returns a new point that is equal to the difference of the two points.
	 * @author Ariel David
	 */
	public Vector subtract(Point other) {
		return new Vector(point.subtract(other.point));
	}

	/**
	 * returns a new point that is equal to the sum of the two points.
	 * @author Ariel David
	 */
	public Point add(Vector v) {
		return new Point(this.point.add(v.point));
	}

	@Override
	public String toString() {
		return "Point: " + point + '\n';
	}
}
