/**
 * 
 */
package unitests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import primitives.Vector;
import primitives.Point;
import geometries.Triangle;

/**
 * @author Ariel David and Moshe Weisfish
 *
 */
class TriangleTests {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Triangle triangle = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

		// TC01: a simple test to make sure the function does not throw an exception.
		assertDoesNotThrow(() -> triangle.getNormal(new Point(0, 1, 0)),
				"Triangle threw an exeption while attempting getNormal function");
		Vector N = triangle.getNormal(new Point(0, 1, 0));

		// TC02: making sure normal length = 1 'aka' a unit vector.
		assertEquals(1, N.length(), 0.00000001, "Triangle's normal is not a unit vector");

	}
}
