/**
 * 
 */
package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;
import geometries.Intersectable.GeoPoint;

/**
 * a class for basic ray tracing that extends RayTracerBase
 * 
 * @author Ariel
 *
 */
public class RayTracerBasic extends RayTracerBase {

	// constructor
	/**
	 * constructs a ray tracer with a given scene
	 * 
	 * @param s scene
	 */
	public RayTracerBasic(Scene s) {
		super(s);
	}

	@Override
	public Color traceRay(Ray ray) {
		var intersections = scene.geometries.findGeoIntersections(ray);
		return (intersections != null) ? calcColor(ray.findClosestGeoPoint(intersections)) : scene.background;
	}

	/**
	 * calculates the color of a given point on a geometry body
	 * @param gp point on a geometry body
	 * @return color of the point
	 */
	private Color calcColor(GeoPoint gp) {
		return scene.ambientLight.getIntensity().add(gp.geometry.getEmission());
	}

}
