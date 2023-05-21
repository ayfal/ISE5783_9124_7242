/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

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
		return null;
	}

}
