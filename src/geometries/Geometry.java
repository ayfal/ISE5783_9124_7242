package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * abstract class Geometry is the abstract class representing all geometries in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public abstract class Geometry extends Intersectable {

	/**
	 * color of the geometry body
	 */
	protected Color emission = Color.BLACK;
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
	 * @return color of the geometry body
	 */
	public Color getEmission() {
		return emission;
	}

	/**
	 * set the color of the geometry body
	 * @param emission color of the geometry body
	 * @return the geometry body
	 */
	public Geometry setEmission(Color e) {
		emission = e;
		return this;
	}
}
