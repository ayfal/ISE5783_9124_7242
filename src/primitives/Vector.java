package primitives;

/**
 * Class Vector is the basic class representing a direction in a Cartesian
 * 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public class Vector extends Point {

	// constructors
	
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

	/**
	 * returns a new vector that is equal to the sum of the vectors
	 * @author Ariel David
	 */
	public Vector add(Vector v) {
		return new Vector(this.point.add(v.point));
	}


	/**
	 * returns a new vector with the same direction but the length is multiplied.
	 * @author Ariel David
	 */
	public Vector scale(double num) {
		return new Vector(this.point.scale(num));
	}

	/**
	 * Calculates a scalar value of dot-product operation between this vector and another vector:
	 *  If the dot product is positive, 
	 *    the vectors are pointing in roughly the same direction,and the angle between them is acute.
	 *  If the dot product is negative,
	 *    the vectors are pointing in roughly opposite directions, and the angle between them is obtuse.
	 *  If the dot product is zero, the vectors are perpendicular to each other.
	 * 
	 * @param v the another vector
	 * @return the calculation result
	 */
	public double dotProduct(Vector v) {

		double r1 = this.point.d1 * v.point.d1;
		double r2 = this.point.d2 * v.point.d2;
		double r3 = this.point.d3 * v.point.d3;

		return r1 + r2 + r3;
	}

	/**
	 * returns a new vector that is perpendicular to both input vectors
	 * defined as a vector that is perpendicular to both A and B,
	 * with a length equal to the product of their lengths multiplied by the "sin" of the angle between them.
	 * The direction of the resulting vector is determined by the "right hand" rule.
	 * 
	 * @author Ariel David
	 */
	public Vector crossProduct(Vector v) {

		double r1 = this.point.d2 * v.point.d3 - this.point.d3 * v.point.d2;
		double r2 = this.point.d3 * v.point.d1 - this.point.d1 * v.point.d3;
		double r3 = this.point.d1 * v.point.d2 - this.point.d2 * v.point.d1;

		return new Vector(r1, r2, r3);
	}

	/**
	 * returns the length squared of the vector.
	 * 
	 * @author Ariel David
	 */
	public double lengthSquared() {

		return this.point.d1 * this.point.d1 //
				+ this.point.d2 * this.point.d2 //
				+ this.point.d3 * this.point.d3;
	}

	/**
	 * returns the length of the vector.
	 * 
	 * @author Ariel David
	 */
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}

	/**
	 * returns a new vector that has a magnitude of 1, with the same direction as the
	 * original vector.
	 * 
	 * @author Ariel David
	 */
	public Vector normalize() {
		return new Vector(this.point.reduce(this.length()));
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
