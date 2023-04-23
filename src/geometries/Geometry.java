package geometries;
 
import primitives.Point;
import primitives.Vector;

/**
 * Interface Geometry is the Interface representing all geometries in a
 * Cartesian 3-Dimensional coordinate system.
 * 
 * @author Ariel David 
 */
public interface Geometry {
	 
   Vector getNormal(Point p);
} 
