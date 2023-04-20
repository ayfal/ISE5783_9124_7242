package primitives;

/**
 * Class Point is the basic class representing a … of Euclidean geometry in
 * Cartesian 3-Dimensional coordinate system.
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

		if (this.equals(other))
			return 0;

		double x = this.point.d1 - other.point.d1;
		double y = this.point.d2 - other.point.d2;
		double z = this.point.d3 - other.point.d3;

		return x * x + y * y + z * z;
	}

	public double distance(Point other) {
		return Math.sqrt(this.distanceSquared(other));
	}

	public Vector subtract(Point other) {
		return new Vector(point.subtract(other.point));
	}

	public Point add(Vector v) {
		return new Point(this.point.add(v.point));
	}

	@Override
	public String toString() {
		return "Point: " + point + '\n';
	}
}
