/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * abstract class for ray tracers
 * 
 * @author Ariel
 *
 */
public abstract class RayTracerBase {
	protected Scene scene;

	// constructor
	/**
	 * constructs a ray tracer with a given scene
	 * 
	 * @param s scene
	 */
	public RayTracerBase(Scene s) {
		scene = s;
	}

	/**
	 * trace a ray and return the color of the closest intersection
	 * 
	 * @param ray ray to trace
	 * @return color of the closest intersection
	 */
	public abstract Color traceRay(Ray ray);
}
