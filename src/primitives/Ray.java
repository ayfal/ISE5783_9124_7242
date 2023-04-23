package primitives;

/**
 * Class Ray is the basic class representing a point and a direction in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David and Moshe
 */

public class Ray {

	final Point p0;
  
	final Vector dir;

	// constructor
	public Ray(Point p, Vector d) {
		d.normalize();

		this.p0 = p;
		this.dir = d;
	}

	// getters
	public Point getP0() {
		return p0;
	}

	public Vector getDir() {
		return dir;
	}

	// functions
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return (obj instanceof Ray other) && (this.p0.equals(other.p0) && this.dir.equals(other.dir));
	}

	@Override
	public String toString() {
		return "Ray { p0 =  " + p0 + ", dir = " + dir + " }\n";
	}
}
