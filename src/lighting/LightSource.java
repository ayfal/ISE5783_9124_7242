package lighting;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * 
 */
public interface LightSource {
	/**
	 * calculates the intensity of light at a point
	 * 
	 * @param p point to calculate intensity at
	 * @return intensity of light at point
	 */
	public Color getIntensity(Point p);

	/**
	 * calculates the direction of light at a point
	 * 
	 * @param p point to calculate direction at
	 * @return direction of light at point
	 */
	public Vector getL(Point p);

	/**
	 * calculates the distance between the light source and a point
	 * 
	 * @param point point to calculate distance from
	 * @return distance between the light source and a point
	 */
	public double getDistance(Point point);

}
