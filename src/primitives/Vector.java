package primitives;

/**
 * Class Vector is the basic class representing a … of Euclidean geometry in
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David and Moshe
 */
public class Vector extends Point {
  
	public Vector(double d1, double d2, double d3) {
		super(d1, d2, d3);
		if (point.equals(Double3.ZERO))
			throw new IllegalArgumentException(" Vector(0,0,0) doesn't exist ");
	}

	public Vector(Double3 d) {
		this(d.d1, d.d2, d.d3);
	}

	// functions

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return (obj instanceof Vector other) && this.point.equals(other.point);
	}

	public Vector add(Vector v) {
		return new Vector(this.point.add(v.point));
	}

	public Vector scale(double num) {
		return new Vector(this.point.scale(num));
	}

	public double dotProduct(Vector v) {

		double r1 = this.point.d1 * v.point.d1;
		double r2 = this.point.d2 * v.point.d2;
		double r3 = this.point.d3 * v.point.d3;

		return r1 + r2 + r3;
	}

	public Vector crossProduct(Vector v) {

		double r1 = this.point.d2 * v.point.d3 - this.point.d3 * v.point.d2;
		double r2 = this.point.d3 * v.point.d1 - this.point.d1 * v.point.d3;
		double r3 = this.point.d1 * v.point.d2 - this.point.d2 * v.point.d1;

		return new Vector(r1, r2, r3);
	}

	public double lengthSquared() {

		return this.point.d1 * this.point.d1 //
				+ this.point.d2 * this.point.d2 //
				+ this.point.d3 * this.point.d3;
	}

	public double length() {
		return Math.sqrt(this.lengthSquared());
	}

	public Vector normalize() {
		return new Vector(this.point.reduce(this.length()));
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
