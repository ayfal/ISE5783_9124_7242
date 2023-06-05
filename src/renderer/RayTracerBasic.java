/**
 * 
 */
package renderer;

//import java.util.List;

import primitives.Color;
import primitives.Double3;
import primitives.Material;
//import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;
import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import static primitives.Util.*;

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
		return (intersections != null) ? calcColor(ray.findClosestGeoPoint(intersections), ray) : scene.background;
	}

	/**
	 * calculates the color of a given point on a geometry body
	 * 
	 * @param gp point on a geometry body
	 * @param ray the light ray
	 * @return color of the point
	 */
	private Color calcColor(GeoPoint gp, Ray ray) {
		return scene.ambientLight.getIntensity().add(calcLocalEffects(gp, ray));   //gp.geometry.getEmission());
	}

	private Color calcLocalEffects(GeoPoint gp, Ray ray) {
		Color color = gp.geometry.getEmission();
		Vector v = ray.getDir (); 
		Vector n = gp.geometry.getNormal(gp.point);
		double nv = alignZero(n.dotProduct(v)); 
		if (nv == 0) return color;
		Material material = gp.geometry.getMaterial();
		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(gp.point);
			double nl = alignZero(n.dotProduct(l));
			if (nl * nv > 0) {
				Color iL = lightSource.getIntensity(gp.point);
				color = color.add(iL.scale(calcDiffusive(material, nl)),
				iL.scale(calcSpecular(material, n, l, nl, v)));
			}
		}
		return color;		
	}

	/**
     * Calculate the specular component of the light reflected from the surface of the object.
     *
     * @param material the material of the object
     * @param n normal vector
     * @param l direction from light to point
     * @param nl dot-product of the normal vector and the light vector
     * @param v view vector
     * @return The specular component factor.
     */
    private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
        Vector r = l.add(n.scale(-2 * nl));//decalared a variable for readablity
        double minusVR = -alignZero(r.dotProduct(v));
        return (minusVR <= 0) ? Double3.ZERO : 
			material.kS.scale(Math.pow(minusVR, material.nShininess));
    }

    /**
     * Calculates Diffusive component of light reflection
     *
     * @param material The material of the object that the ray hit.
     * @param nl the dot-product of the normal and the light direction
     * @return The diffuse component factor.
     */
    private Double3 calcDiffusive(Material material, double nl) {
        return material.kD.scale(Math.abs(nl));
    }

}
