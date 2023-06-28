package lighting;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.*;

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

	/**
	 * calculates the shadow grid vectors of a point
	 * 
	 * @param gp point to calculate shadow grid vectors at
	 * @param vTo direction of light
	 * @return shadow grid vectors of a point
	 */
	public List<Vector> getShadowGridVectors(GeoPoint gp, Vector vTo);

}
