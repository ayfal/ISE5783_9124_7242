/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;
import geometries.Plane;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class PlaneTests {

	/**
	 * Test method for
	 * {@link geometries.Plane#Plane(primitives.Point, primitives.Point, primitives.Point)}.
	 */
	@Test
	void testPlanePointPointPoint() { // constructor.
		// =============== Boundary Values Tests ==================
		// TC01: The first 2 point are the same
		assertThrows(IllegalArgumentException.class,
				() -> new Plane(new Point(1, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0)),
				"The first two points are the same");

		// TCO2: The points are on the same line
		assertThrows(IllegalArgumentException.class,
				() -> new Plane(new Point(1, 0, 0), new Point(2, 0, 0), new Point(3, 0, 0)),
				"The points are on the same line");

	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Plane plane = new Plane(new Point(1, 0, 1), new Point(3, 1, 7), new Point(2, 5, 3));
		Vector n = plane.getNormal();

		// TC01: making sure normal length = 1 'aka' a unit vector.
		assertEquals(1, n.length(), 0.00000001, "Plane's normal is not a unit vector");

		// TCO2: a simple test to check the result of the function
		assertEquals(new Vector(-28, 2, 9).normalize(), n, "Plane's normal is wrong");
	}

}
