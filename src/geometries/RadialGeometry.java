package geometries;

public abstract class RadialGeometry implements Geometry {

	protected final double radius;

	public RadialGeometry(double r) {
		this.radius = r;
	}
}
  