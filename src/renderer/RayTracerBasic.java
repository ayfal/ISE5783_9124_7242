/**
 * 
 */
package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point;
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
        public Color traceRay(Ray ray){
            List<Point> intersections = scene.geometries.findIntersections(ray);
            return (intersections != null) ? calcColor(ray.findClosestPoint(intersections)) : scene.background;
        }

        private Color calcColor(Point point) {
            return scene.ambientLight.getIntensity();
        }

}
