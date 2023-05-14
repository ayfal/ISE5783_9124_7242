package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Interface Geometry is the Interface representing all geometries in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David
 */
public interface Geometry extends Intersectable {
	/**
	 * get normal vector to the surface of the geometry body at a given point on the
	 * surface
	 * 
	 * @param p point on the surface
	 * @return normal vector
	 */
	Vector getNormal(Point p);
}
