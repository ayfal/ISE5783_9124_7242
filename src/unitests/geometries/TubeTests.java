/**
 * 
 */
package unitests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;
import primitives.Ray;
import geometries.Tube;

/**
 * Test Tube class methods
 * 
 * @author Ariels
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
		Vector n = tube.getNormal(new Point(2, 0, 1));

		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(1, 0, 0), n, "normal is wrong");

		// =============== Boundary Values Tests ==================
		// TC02: when the PP0 is orthogonal to the tube's ray.
		n = tube.getNormal(new Point(0, 2, 0));
		assertEquals(new Vector(0, 1, 0), n, "normal is wrong");
	}

}
