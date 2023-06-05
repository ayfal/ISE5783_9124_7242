package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * class for spot light
 */
public class SpotLight extends PointLight {
	private final Vector direction;

	// ***************** Constructors ********************** //

	/**
	 * constructor for spot light
	 * 
	 * @param intensity color of light
	 * @param p         position of light
	 * @param d         direction of light
	 */
	public SpotLight(Color intensity, Point p, Vector d) {
		super(intensity, p);
		direction = d.normalize();
	}

	// ***************** Functions ********************** //

	@Override
	public Color getIntensity(Point p) {
		double projection = direction.dotProduct(getL(p));
		return (projection <= 0) ? Color.BLACK : super.getIntensity(p).scale(projection);
	}
}
