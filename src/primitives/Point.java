package primitives;

/**
 * Class Point is the basic class representing a coordinate in a 3-Dimensional space.
 * 
 * @author Ariel David and Moshe Weisfish
 */
public class Point {

	final Double3 point;

	/**
	 * returns the point (0,0,0).
	 */
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
	 * calculates the distance between the two points.
	 * 
	 * @param other the other point.
	 * @return the distance between this and the other point.
	 */
	public double distance(Point other) {
		return Math.sqrt(this.distanceSquared(other));
	}

	/**
	 * calculates a new vector that is equal to the subtraction of the two points.
	 * 
	 * @param other the other point.
	 * @return a new vector that is equal to the subtraction of this and the other point.
	 */
	public Vector subtract(Point other) {
		return new Vector(point.subtract(other.point));
	}

	/**
	 * calculates a new point that is equal to the addition of the point and the vector.
	 * 
	 * @param v the vector.
	 * @return a new point that is equal to the addition of this and the vector.
	 */
	public Point add(Vector v) {
		return new Point(this.point.add(v.point));
	}

	@Override
	public String toString() {
		return "Point: " + point + '\n';
	}
}
