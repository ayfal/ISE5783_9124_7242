/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;
import geometries.Tube;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class TubeTests {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Ray axis = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
		Tube tube = new Tube(2, axis);
		Vector N = tube.getNormal(new Point(2, 0, 1));

		// TC01: making sure normal length = 1 'aka' a unit vector.
		assertEquals(1, N.length(), 0.00000001, "Ray's normal is not a unit vector");

		// TC02: a simple test to check the result of the function
		assertEquals(new Vector(1, 0, 0), N, "Ray's normal is wrong");////// it should be a ray not a vector, no?
	}

}
