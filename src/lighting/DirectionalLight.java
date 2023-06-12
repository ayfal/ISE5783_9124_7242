package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * class for directional light
 */
public class DirectionalLight extends Light implements LightSource {
	private final Vector direction;

	// ***************** Constructors ********************** //

	/**
	 * constructor for directional light
	 * 
	 * @param intensity color of light
	 * @param d         direction of light
	 */
	public DirectionalLight(Color intensity, Vector d) {
		super(intensity);
		direction = d.normalize();
	}

	// ***************** Functions ********************** //

	@Override
	public Color getIntensity(Point p) {
		return intensity;
	}

	@Override
	public Vector getL(Point p) {
		return direction;
	}

	@Override
	public double getDistance(Point point) {
		return Double.POSITIVE_INFINITY;
	}
}