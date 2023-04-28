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
import geometries.Cylinder;

/**
 * @author Ariel
 *
 */
class CylinderTests {

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
		Cylinder cylinder = new Cylinder(2, 1, ray);
		// simple tests to check the result of the function:

		// TC01: on the side of the cylinder
		Vector n = cylinder.getNormal(new Point(0, 1, 1));
		assertEquals(new Vector(0, 1, 0), n, "normal is wrong");

		// TC02: on the upper base of the cylinder
		n = cylinder.getNormal(new Point(0, 1, 2));
		assertEquals(new Vector(0, 0, 1), n, "normal is wrong");

		// TC03: on the lower base of the cylinder
		n = cylinder.getNormal(new Point(0, 1, 0));
		assertEquals(new Vector(0, 0, -1), n, "normal is wrong");

		// =============== Boundary Values Tests ==================
		// TC4: in the center of the upper base of the cylinder
		n = cylinder.getNormal(new Point(0, 0, 2));
		assertEquals(new Vector(0, 0, 1), n, "normal is wrong");

		// TC05: in the center of the lower base of the cylinder
		n = cylinder.getNormal(new Point(0, 0, 0));
		assertEquals(new Vector(0, 0, -1), n, "normal is wrong");
	}

}
