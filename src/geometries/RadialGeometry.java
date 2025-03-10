package geometries;

/**
 * the abstract class RadialGeometry is a class that implements Geometry,
 * representing all "radial geometries" such as: Sphere, Tube and Cylinder, in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public abstract class RadialGeometry extends Geometry {

	/**
	 * radius of the radial geometry
	 */
	protected final double radius;

	/**
	 * squared radius of the radial geometry
	 */
	protected final double radius2;

	// constructor
	/**
	 * constructor for a radial geometry
	 * 
	 * @param r double radius
	 */
	public RadialGeometry(double r) {
		this.radius = r;
		this.radius2 = r * r;
	}

	// getters
	/**
	 * get radius
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
}
