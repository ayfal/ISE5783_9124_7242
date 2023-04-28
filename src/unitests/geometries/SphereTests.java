/**
 * 
 */
package unitests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;
import geometries.Sphere;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Sphere sphere = new Sphere(3, new Point(0, 0, 0));
		Vector n = sphere.getNormal(new Point(3, 0, 0));

		// TC01: a simple test to check the result of the function
		assertEquals(new Vector(1, 0, 0), n, "Shpere's normal is wrong");
	}

}
