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

	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final Double3 INITIAL_K = Double3.ONE;

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
		GeoPoint closestPoint = findClosestIntersection(ray);
		return (closestPoint == null) ? scene.background : calcColor(closestPoint, ray);
	}

	/**
	 * calculates the color of a given point on a geometry body
	 * 
	 * @param gp  point on a geometry body
	 * @param ray the light ray
	 * @return color of the point
	 */
	private Color calcColor(GeoPoint gp, Ray ray) {
		// return scene.ambientLight.getIntensity().add(calcLocalEffects(gp, ray));
		return calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(scene.ambientLight.getIntensity());
	}

	/**
	 * calculates the color made by a ray on a given point on a geometry. takes into
	 * account global and local effects
	 * 
	 * @param gp    the point on the geometry body
	 * @param ray   the light ray
	 * @param level the level of recursion
	 * @param k     the k factor (how much to scale the color)
	 * @return the color of the point
	 */
	private Color calcColor(GeoPoint gp, Ray ray, int level, Double3 k) {
		Vector v = ray.getDir();
		Vector n = gp.geometry.getNormal(gp.point);
		double nv = n.dotProduct(v);
		if (isZero(nv))
			return Color.BLACK;

		Color color = calcLocalEffects(gp, v, n, nv, k);
		return level == 1 ? color : color.add(calcGlobalEffects(gp, v, n, nv, level, k));
	}

	/**
	 * calculates the local effects of lights on a given point on a geometry body in
	 * a scene
	 * 
	 * @param gp the point on the geometry body
	 * @param v  the light ray direction
	 * @param n  the normal vector from the point in the geometry body (aka gp)
	 * @param nv the dot-product value of n and v.
	 * @return the color of the point
	 */
	private Color calcLocalEffects(GeoPoint gp, Vector v, Vector n, double nv, Double3 k) {
		Color color = gp.geometry.getEmission();
		Material material = gp.geometry.getMaterial();
		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(gp.point);
			double nl = n.dotProduct(l);
			if (alignZero(nl * nv) > 0) {
				// former code: if (unshaded(gp, lightSource, l, n))
				Double3 ktr = softenShadows(gp, lightSource, l, n);
				if (ktr.product(k).greaterThan(MIN_CALC_COLOR_K)) {
					Color iL = lightSource.getIntensity(gp.point).scale(ktr);
					color = color.add(iL.scale(calcDiffusive(material, nl) //
							.add(calcSpecular(material, n, l, nl, v))));
				}
			}
		}
		return color;
	}

	/**
	 * Calculate global effects - recursion
	 *
	 * @param gp    the point
	 * @param v     the light ray direction
	 * @param n     the normal vector from the point in the geometry body (aka gp)
	 * @param nv    the dot-product value of n and v.
	 * @param level the level of recursion
	 * @param k     the k factor (how much to scale the color)
	 * @return color
	 */
	private Color calcGlobalEffects(GeoPoint gp, Vector v, Vector n, double nv, int level, Double3 k) {
		Material material = gp.geometry.getMaterial();
		return calcGlobalEffect(createReflectedRay(gp, v, n, nv), level, k, material.kR)
				.add(calcGlobalEffect(createRefractedRay(gp, v, n), level, k, material.kT));
	}

	/**
	 * Calculate global effects of reflection and refraction on the scene -
	 * recursion
	 * 
	 * @param ray   the ray from the camera to the point
	 * @param level the level of recursion
	 * @param k     the k factor (how much to scale the color)
	 * @param kx    the kx factor (kR or kT)
	 * 
	 */
	private Color calcGlobalEffect(Ray ray, int level, Double3 k, Double3 kx) {
		Double3 kkx = k.product(kx);
		if (kkx.lowerThan(MIN_CALC_COLOR_K))
			return Color.BLACK;

		GeoPoint gp = findClosestIntersection(ray);
		return (gp == null ? scene.background : calcColor(gp, ray, level - 1, kkx)).scale(kx);
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
	 * 
	 * @param gp the point
	 * @param l  the light source direction
	 * @param n  the normal vector
	 * @return true if the point is unshaded, false otherwise
	 */
	@SuppressWarnings("unused")
	private boolean unshaded(GeoPoint gp, LightSource light, Vector l, Vector n) {
		Ray lightRay = new Ray(gp.point, l.scale(-1), n);
		var intersections = scene.geometries.findGeoIntersections(lightRay);
		if (intersections == null)
			return true;

		double lightDistance = light.getDistance(gp.point);
		for (GeoPoint geoPoint : intersections) {
			if (alignZero(geoPoint.point.distance(gp.point) - lightDistance) <= 0
					&& geoPoint.geometry.getMaterial().kT == Double3.ZERO) // should we use this, just without
				return false;
		}
		return true;
	}

	/**
	 * Calculate the transparency of the point (how much light passes through it)
	 * 
	 * @param geoPoint the point
	 * @param ls       the light source
	 * @param l        the light source direction
	 * @param n        the normal vector
	 * @return the transparency of the point
	 */

	private Double3 transparency(GeoPoint geoPoint, LightSource ls, Vector l, Vector n) {
		Ray lightRay = new Ray(geoPoint.point, l.scale(-1), n);
		var intersections = scene.geometries.findGeoIntersections(lightRay);
		Double3 ktr = Double3.ONE;
		if (intersections == null)
			return ktr;

		double lightDistance = ls.getDistance(geoPoint.point);
		for (GeoPoint gp : intersections) {
			if (alignZero(geoPoint.point.distance(gp.point) - lightDistance) <= 0) {
				ktr = ktr.product(gp.geometry.getMaterial().kT);
				if (ktr.lowerThan(MIN_CALC_COLOR_K))
					return Double3.ZERO;
			}
		}
		return ktr;
	}

	/**
	 * creates a light's reflected ray from a given point
	 * 
	 * @param gp the point on a geometry body
	 * @param v  the vector from the point to the light source
	 * @param n  the normal vector from the point
	 * @param nv the dot-product value of n and v.
	 * @return the reflected ray
	 */
	private Ray createReflectedRay(GeoPoint gp, Vector v, Vector n, double nv) {
		return new Ray(gp.point, v.subtract(n.scale(2 * nv)), n);
	}

	/**
	 * creates a light's refracted ray from a given point
	 * 
	 * @param p the point on a geometry body
	 * @param v the vector from the point to the light source
	 * @param n the normal vector from the point
	 * @return the refracted ray
	 */
	private Ray createRefractedRay(GeoPoint gp, Vector v, Vector n) {
		return new Ray(gp.point, v, n);
	}

	/**
	 * find the closest intersection point of a ray with the scene's geometries
	 *
	 * @param ray the ray we find the closest intersection of
	 * @return the closest intersection point
	 */
	private GeoPoint findClosestIntersection(Ray ray) {
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
		return (intersections == null) ? null : //
				ray.findClosestGeoPoint(intersections); // returns closest point
	}

	private Double3 softenShadows(GeoPoint geoPoint, LightSource light, Vector l, Vector n) {
		List<Vector> shadowVectors = light.getShadowGridVectors(geoPoint);
		var sumOfKtr = Double3.ZERO;
		for (var shadowVector : shadowVectors)
			sumOfKtr = sumOfKtr.add(transparency(geoPoint, light, shadowVector, n));
		return sumOfKtr.reduce(shadowVectors.size());
	}
}
