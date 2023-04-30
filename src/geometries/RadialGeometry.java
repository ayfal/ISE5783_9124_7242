package geometries;

/**
 * the abstract class RadialGeometry is a class that implements Geometry, representing all "radial geometries"
 * such as: Sphere, Tube and Cylinder, in a Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public abstract class RadialGeometry implements Geometry {

	protected final double radius;

	// constructor
	/**
	 * constructor for a radial geometry
	 * @param r double
	 */
	public RadialGeometry(double r) {
		this.radius = r;
	}
}
  