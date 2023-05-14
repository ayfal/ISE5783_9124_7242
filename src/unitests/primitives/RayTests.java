package unitests.primitives;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Unit tests for primitives.Ray class
 * 
 * @author Ariels
 *
 */
public class RayTests {

	/**
	 * Test method for {@link primitives.Ray#getPoint(double)}.
	 */
	@Test
	void testDistanceSquared() {
		// ============ Equivalence Partitions Tests ==============
		Ray ray = new Ray(new Point(1, 0, 0), new Vector(1, 0, 0));
		// TC01: the scalar is positive
		assertEquals(new Point(2, 0, 0), ray.getPoint(1), "ERROR: getPoint() wrong value");

		// TC02: the scalar is negative
		assertEquals(new Point(-1, 0, 0), ray.getPoint(-2), "ERROR: getPoint() wrong value");

		// =============== Boundary Values Tests ==================
		// TC03: the scalar is zero
		assertEquals(new Point(1, 0, 0), ray.getPoint(0), "ERROR: getPoint() wrong value");
	}
}
