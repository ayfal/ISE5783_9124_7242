/**
 * 
 */
package renderer;

import primitives.*;
import scene.Scene;
import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import static primitives.Util.*;

import java.util.List;

/**
 * a class for basic ray tracing that extends RayTracerBase
 * 
 * @author Ariel
 *
 */
public class RayTracerBasic extends RayTracerBase {

	private static final double DELTA = 0.1;

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
		return (intersections != null) ? calcColor(ray.findClosestGeoPoint(intersections), ray) : scene.background;
	}

	/**
	 * calculates the color of a given point on a geometry body
	 * 
	 * @param gp  point on a geometry body
	 * @param ray the light ray
	 * @return color of the point
	 */
	private Color calcColor(GeoPoint gp, Ray ray) {
		return scene.ambientLight.getIntensity().add(calcLocalEffects(gp, ray));
	}

	private Color calcLocalEffects(GeoPoint gp, Ray ray) {
		Color color = gp.geometry.getEmission();
		Vector v = ray.getDir();
		Vector n = gp.geometry.getNormal(gp.point);
		double nv = n.dotProduct(v);
		if (!isZero(nv)) {
			Material material = gp.geometry.getMaterial();
			for (LightSource lightSource : scene.lights) {
				Vector l = lightSource.getL(gp.point);
				double nl = n.dotProduct(l);
				if (alignZero(nl * nv) > 0) {
					if (unshaded(gp, lightSource, l, n)){
						Color iL = lightSource.getIntensity(gp.point);
					    color = color.add(iL.scale(calcDiffusive(material, nl) //
							.add(calcSpecular(material, n, l, nl, v))));
					}
				}
			}
		}
		return color;
	}

	/**
	 * Calculate the specular component of the light reflected from the surface of
	 * the object.
	 *
	 * @param material the material of the object
	 * @param n        normal vector
	 * @param l        direction from light to point
	 * @param nl       dot-product of the normal vector and the light vector
	 * @param v        view vector
	 * @return The specular component factor.
	 */
	private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
		Vector r = l.add(n.scale(-2 * nl)); // declared a variable for readability
		double minusVR = -alignZero(r.dotProduct(v));
		return minusVR <= 0 ? Double3.ZERO : material.kS.scale(Math.pow(minusVR, material.nShininess));
	}

	/**
	 * Calculates Diffusive component of light reflection
	 *
	 * @param material The material of the object that the ray hit.
	 * @param nl       the dot-product of the normal and the light direction
	 * @return The diffuse component factor.
	 */
	private Double3 calcDiffusive(Material material, double nl) {
		return material.kD.scale(nl < 0 ? -nl : nl);
	}

	/**
	 * checks if a point is unshaded
	 * @param gp the point
	 * @param l the light source direction
	 * @param n the normal vector
	 * @return true if the point is unshaded, false otherwise
	 */
	private boolean unshaded(GeoPoint gp, LightSource light, Vector l, Vector n) {
		// l.scale(-1) is the direction from point to light source
		Vector deltaVector = n.scale(n.dotProduct(l) < 0 ? DELTA : -DELTA);
		Ray lightRay = new Ray(gp.point.add(deltaVector), l.scale(-1)); //seperated to two lines for readability
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
		if (intersections == null)
			return true;
		double lightDistance = light.getDistance(gp.point);
		for (GeoPoint geoPoint : intersections) {
			if (alignZero(geoPoint.point.distance(gp.point) - lightDistance) <= 0 /*&& geoPoint.geometry.getMaterial().kT == 0*/)
				return false;
		}
		return true;
		
	}

}
