package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

/**
 * abstract class Geometry is the abstract class representing all geometries in
 * a Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public abstract class Geometry extends Intersectable {

	/**
	 * color of the geometry body
	 */
	protected Color emission = Color.BLACK;

	/**
	 * material of the geometry body
	 */
	private Material material = new Material();

	// ***************** Getters/Setters ********************** //
	/**
	 * get normal vector to the surface of the geometry body at a given point on the
	 * surface
	 * 
	 * @param p point on the surface
	 * @return normal vector
	 */
	public abstract Vector getNormal(Point p);

	/**
	 * get the color of the geometry body
	 * 
	 * @return color of the geometry body
	 */
	public Color getEmission() {
		return emission;
	}

	/**
	 * set the color of the geometry body
	 * 
	 * @param emission color of the geometry body
	 * @return the geometry body
	 */
	public Geometry setEmission(Color e) {
		emission = e;
		return this;
	}

	/**
	 * get the material of the geometry body
	 * 
	 * @return material of the geometry body
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * set the material of the geometry body
	 * 
	 * @param m material of the geometry body
	 * @return the geometry body itself
	 */
	public Geometry setMaterial(Material m) {
		material = m;
		return this;
	}
}
